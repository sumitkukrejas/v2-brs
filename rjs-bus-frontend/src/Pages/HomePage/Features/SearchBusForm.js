import React, { useEffect, useState } from "react";
import getCityData from "../../../Services/city data/cityData";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";


const SearchBusForm = () => {
  const [fromDropdown, setFromDropdown] = useState(false);
  const [toDropdown, setToDropdown] = useState(false);
  const [dateDropdown, setDateDropdown] = useState(false);
  const [cityDataApi, setCityDataApi] = useState([]);
  const [filteredListFrom, setFilteredListFrom] = useState([]);
  const [filteredListTo, setFilteredListTo] = useState([]);
  const [from, setFrom] = useState("");
  const [to, setTo] = useState("");
  const [date , setDate] = useState(new Date())
  const [displayFrom, setDisplayFrom] = useState(false);
  const [displayTo, setDisplayTo] = useState(false);

  const cityFromOnClick = (e) => {
    setFrom(e.target.value);
    setFromDropdown(false)
    setDisplayFrom(true)
  };

  const cityToOnClick = (e) => {
    setTo(e.target.value);
    setToDropdown(false);
    setDisplayTo(true)
  };

  

  const handleOnChangeFrom = (e) => {
    setFrom(e.target.value);
    const value = from.toLowerCase();
    const filterNamesFrom = cityDataApi.filter((cityName) => {
      return cityName.substr(0, value.length).toLowerCase() === value;
    });
    setFilteredListFrom(filterNamesFrom);
  };

  const handleOnChangeTo = (e) => {
    setTo(e.target.value);
    const value = to.toLowerCase();
    const filterNamesTo = cityDataApi.filter((cityName) => {
      return cityName.substr(0, value.length).toLowerCase() === value;
    });
    setFilteredListTo(filterNamesTo);
  };

  const handleOnSubmit = (e) => {
    e.preventDefault();
    console.log(from)
    console.log(to)
    console.log(date)
  };

  useEffect(() => {
    setCityDataApi(getCityData());
    // .then((response) => {
    //   setCityDataApi(response);
    // });
    console.log(cityDataApi);
  },[]);


  return (
    <form autoComplete="off" onSubmit={handleOnSubmit}>
      <div className="bg-white h-64 rounded-xl text-center mx-10 pt-3">
        <h1 className="text-5xl font-semibold text-search-headding">
          Search Bus
        </h1>
        <div className="flex mt-5 h-fit text-left mx-4">
          <div
            className="border w-2/5 rounded-l-lg"
            onClick={() => setFromDropdown(true)}
          >
            <div className="font-bold text-gray-700  text-lg pl-5 pt-3">
              From
            </div>
            <div className="text-3xl font-bold pl-8">{!displayFrom ?  <div>Delhi , Delhi</div> : <div> {from}</div>  }</div>
            <div className="text-gray-700  text-lg pl-7 font-bold">India</div>
          </div>
          <div
            className="border w-2/5"
            onClick={() => setToDropdown(true)}
          >
            <div className="font-bold text-gray-700  text-lg pl-5 pt-3">To</div>
            <div className="text-3xl font-bold pl-8">{displayTo ? <div>{to}</div> :<div> Chandigarh , Punjab</div>}</div>
            <div className="text-gray-700  text-lg pl-7 font-bold">India</div>
          </div>
          <div className="border w-1/5 rounded-r-lg" onClick={()=>setDateDropdown(true)}>
            <div className="font-bold text-gray-700 text-lg pl-5 pt-3">
              TRAVEL DATE
            </div>
            <div className="flex pl-7 pt-2">
              <div className="text-4xl font-bold">{date.getDate()}</div>
              <div className="pt-2 pl-1 text-2xl font-semibold">{date.toLocaleString('default', { month: 'long' }).substring(0,3)}'{date.getYear()-100}</div>
            </div>
            <div className="text-gray-700  text-lg pl-6 pt-2 font-bold">
              {date.toLocaleDateString("default", { weekday: 'long' })}
            </div>
          </div>
        </div>
        <div className={fromDropdown ? "z-20 absolute" : "hidden"}>
          <div className="border w-56 ml-6 absolute bg-white">
            <input
              type="text"
              placeholder="from"
              className="bg-white h-8 outline-none"
              onChange={handleOnChangeFrom}
              name="from"
              value={from}
            />
            <hr></hr>
            <ul className="pl-3">
              {filteredListFrom.map((data) => (
                <li className="" key={data}>
                  <button
                    className="w-full text-start"
                    type="button"
                    onClick={cityFromOnClick}
                    value={data}
                  >
                    {data}
                  </button>
                </li>
              ))}
            </ul>
          </div>
        </div>
        <div className={toDropdown ? "z-20 absolute" : "hidden"}>
          <div className="border w-56 ml-96 absolute bg-white">
            <input
              type="text"
              placeholder="to"
              className="bg-white h-8 outline-none"
              onChange={handleOnChangeTo}
              name="to"
              value={to}
            />
            <hr></hr>
            <ul className="pl-3 bg-black/50">
              {filteredListTo.map((data) => (
                <li className="" key={data}>
                  <button
                    className="w-full text-start"
                    type="button"
                    onClick={cityToOnClick}
                    value={data}
                  >
                    {data}
                  </button>
                  
                </li>
              ))}
              <hr></hr>
            </ul>
          </div>
        </div>
        
        <DatePicker className="min-w-0 max-w-0" selected={date} open={dateDropdown} onChange={(dates)=>{setDate(dates);setDateDropdown(false);}}/>
        <button
          type="submit"
          className="border text-3xl mt-3 text-white font-semibold rounded-full px-16 py-1 bg-gradient-to-r from-search-left to-search-right"
        >
          SEARCH
        </button>
      </div>
      <div
        className={fromDropdown || toDropdown || dateDropdown ? "z-10" : "hidden"}
        onClick={() => {
          setFromDropdown(false);
          setToDropdown(false);
          setDateDropdown(false)
        }}
      >
        <div className="absolute top-0 bottom-0 left-0 right-0 "></div>
      </div>
    </form>
  );
};

export default SearchBusForm;
