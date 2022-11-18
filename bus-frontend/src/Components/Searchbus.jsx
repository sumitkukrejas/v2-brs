import React, { useState, useEffect } from "react";
// import { searchBus } from "../Services/BusService";
import BusService from "../Services/BusService";
import ResultTable from "./ResultTable";
import styles from "./LandingPage.module.css";
import Button from "react-bootstrap/Button";
import "./styles.css"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

const Searchbus = () => {
  //   const [click, setclick] = useState(0);
  //   const [buses, setbuses] = useState([]);
  //   const [source, setsource] = useState("");
  //   const [to, seto] = useState("");

  //   const handleFrom = (s) => {
  //     const value = s.target.value;
  //     setsource(value);
  //   };

  //   const handleTo = (d) => {
  //     const value = d.target.value;
  //     seto(value);
  //   };
  //   const handleClick = async () => {
  //     try {
  //       const response = await BusService.searchBus(source, to);

  //       setbuses(response.data);
  //       if (buses.length === 0) {
  //         alert("SORRY WE DONT SERVE IN THIS AREA");
  //       }
  //     } catch (error) {
  //       console.log(error);
  //     }
  //     console.log("searched");
  //     // console.log(response);
  //     setclick(click + 1);
  //   };

  //   // useEffect(() => {
  //   //   console.log(buses[0]);
  //   // }, [click]);

  //   return (
  //     <div className={styles.total_form}>
  //       {/* <h1>Search your favourite bus !!!</h1> */}

  //       <div className={styles.type_form}>
  //         {/* <label>Source</label> */}
  //         <input
  //           type="text"
  //           name="routeFrom"
  //           placeholder="FROM"
  //           className="styles.type_from"
  //           value={source}
  //           onChange={(s) => handleFrom(s)}
  //         />
  //       </div>

  //       <div className={styles.type_date}>
  //         <input type="date" placeholder="DATE" />
  //       </div>

  //       <div>
  //         {/* <label>Distination</label> */}
  //         <input
  //           type="text"
  //           name="routeTo"
  //           className={styles.type_to}
  //           placeholder="TO"
  //           value={to}
  //           onChange={(d) => handleTo(d)}
  //         />
  //       </div>

  //       <div>
  //         <button className={styles.link} onClick={handleClick} type="submit">
  //           Search Buses
  //         </button>
  //       </div>

  //       <div>{buses.length > 0 && <div>{<ResultTable data={buses} />}</div>}</div>
  //     </div>
  //   );
  // };

  const style = {
    color: "white",
    margin: "70px",
    height:"50px",
    background:"rgb(160,160,160)",
    borderRadius: 15,
  };

  const divStyle = {
    // display: "flex",
    alignItems: "center",
    justifyContent: "center",
  };
  const [click, setclick] = useState(0);
  const [buses, setbuses] = useState([]);
  const [source, setsource] = useState("");
  const [to, seto] = useState("");

  const handleFrom = (s) => {
    const value = s.target.value;
    setsource(value);
  };

  const handleTo = (d) => {
    const value = d.target.value;
    seto(value);
  };
  const handleClick = async () => {
    const response = await BusService.serachBus(source, to);

    setbuses(response.data);
    console.log(buses.length);

    console.log("searched");
    // console.log(response);
    setclick(click + 1);
  };

  return (
    <>
      <div className="container1 col-md-8">
        <div className="from-to">
          <h1>Search your Bus !!!</h1>
          
            {/* <label
              style={{ marginRight: "auto", color: "blue", fontWeight: "bold" }}
            >
              Source{" "}
            </label> */}
            <input
              style={style}
              type="text"
              name="routeFrom"
              placeholder="Source"
              className="source-div"
              value={source}
              onChange={(s) => handleFrom(s)}
            />
          

          <FontAwesomeIcon icon="fa-solid fa-arrow-right" />
            {/* <label
              style={{ marginRight: "auto", color: "blue", fontWeight: "bold" }}
            >
              Distination{" "}
            </label> */}
            <input
              style={style}
              className="destination"
              type="text"
              name="routeTo"
              placeholder="Destination"
              value={to}
              onChange={(d) => handleTo(d)}
            />
          

          <div>
            <Button variant="success" onClick={handleClick} type="submit">
              SEARCH
            </Button>{" "}
          </div>

          {/* <div>
      <ResultTable data={buses} />
    </div> */}

          <div>
            {buses.length > 0 && <div>{<ResultTable data={buses} />}</div>}
          </div>
        </div>
      </div>
    </>
  );
};
export default Searchbus;
