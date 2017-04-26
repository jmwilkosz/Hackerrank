const options = {
    getMap: (objArray) => {

        let map = new Map();

        for (var i = 0, len = objArray.length; i < len; i++) {
            let word = objArray[i];

            map.set(word, map.has(word)
                ? map.get(word) + 1
                : 1);
        }

        return map;
    },
    magazine: "This is the WorkinG MagaZine",
    ransome: "is the4",
};

(function main(options) {

    let magazine = options.magazine.split(' ');
    let ransom = options.ransome.split(' ');
    let magazineHash = options.getMap(magazine);

    for (let i = 0, len = ransom.length; i < len; i++) {
        let count = magazineHash.get(ransom[i]);

        if (count && count > 0) {
            magazineHash.set(ransom[i], count - 1);
        } else {
            console.log("No");
            return;
        }
    }
    console.log("Yes");
})(options);