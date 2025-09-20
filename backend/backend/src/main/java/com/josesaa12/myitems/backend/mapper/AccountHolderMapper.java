package com.josesaa12.myitems.backend.mapper;

import com.josesaa12.myitems.backend.dto.AccountHolderRequest;
import com.josesaa12.myitems.backend.dto.AccountHolderResponse;
import com.josesaa12.myitems.backend.model.AccountHolder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AccountHolderMapper {

    public static AccountHolderResponse toResponse(AccountHolder e) {
        AccountHolderResponse r = new AccountHolderResponse();
        r.setId(e.getId());
        r.setName(e.getName());
        r.setDescription(e.getDescription());
        r.setTags(csvToList(e.getTagsCsv()));
        r.setCreatedAt(e.getCreatedAt());
        r.setUpdatedAt(e.getUpdatedAt());
        return r;
    }

    public static void apply(AccountHolder e, AccountHolderRequest rq) {
        e.setName(rq.getName());
        e.setDescription(rq.getDescription());
        e.setTagsCsv(listToCsv(rq.getTags()));
    }

    private static List<String> csvToList(String csv) {
        if (csv == null || csv.isBlank()) return List.of();
        return Arrays.stream(csv.split(","))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .toList();
    }

    private static String listToCsv(List<String> list) {
        if (list == null || list.isEmpty()) return null;
        return list.stream()
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining(","));
    }
}
