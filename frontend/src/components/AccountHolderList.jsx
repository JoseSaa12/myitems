import { useEffect, useState } from "react";
import { getPaged } from "../api/accountHolders/accountHolders";

function AccountHolderList() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    getPaged(0, 5, "id", "ASC").then(res => {
      setData(res.data); // data viene del backend
      setLoading(false);
    });
  }, []);

  if (loading) return <p>Cargando...</p>;

  return (
    <div>
      <h2>Account Holders</h2>
      <ul>
        {data.map(item => (
          <li key={item.id}>
            <b>{item.name}</b> - {item.description}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default AccountHolderList;
