import  { useEffect, useState } from "react";

const useFetchApi=(url)=>{
  const [data, setData] = useState();

  useEffect(() => {
      fetch(url)
      .then((res) => res.json())
      .then((data) => setData(data));
  }, [url]);
  // return data as array so added []
  return [data];
}

export default useFetchApi
