package com.josesaa12.myitems.backend.mapper;

import com.josesaa12.myitems.backend.dto.AccountHolderRequest;
import com.josesaa12.myitems.backend.dto.AccountHolderResponse;
import com.josesaa12.myitems.backend.model.AccountHolder;

import java.util.*;
import java.util.stream.Collectors;

public final class AccountHolderMapper {

    private AccountHolderMapper() {}

    public static AccountHolderResponse toResponse(AccountHolder e) {
        AccountHolderResponse r = new AccountHolderResponse();
        r.setId(e.getId());
        r.setName(e.getName());
        r.setDescription(e.getDescription());
        r.setTags(splitCsv(e.getTagsCsv()));
        r.setCreatedAt(e.getCreatedAt());
        r.setUpdatedAt(e.getUpdatedAt());
        return r;
    }

    public static void apply(AccountHolder e, AccountHolderRequest req) {
        e.setName(req.getName());
        e.setDescription(req.getDescription());
        e.setTagsCsv(joinCsv(req.getTags()));
    }

    // --- helpers ---
    private static List<String> splitCsv(String csv) {
        if (csv == null || csv.isBlank()) return Collections.emptyList();
        return Arrays.stream(csv.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    private static String joinCsv(List<String> tags) {
        if (tags == null || tags.isEmpty()) return null;
        return tags.stream()
                .map(s -> s == null ? "" : s.trim())
                .filter(s -> !s.isEmpty())
                .distinct()
                .collect(Collectors.joining(","));
    }
}