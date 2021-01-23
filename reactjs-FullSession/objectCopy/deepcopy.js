
data={

    one:"js",
    two:"c++",
    three:"python",
    four:"java"

}

//
shallowcopy = data;


//

deepcopy1 = {... data};


deepcopy2 = data.assign({},data);


deepcopy3 = JSON.parse(JSON.stringify(data));