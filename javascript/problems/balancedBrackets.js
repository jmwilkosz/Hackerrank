const options = {
    isBalanced: (chars) => {
        let stack = [],
            size = 0;

        let braceMap = new Map(
            ['}', '{'],
            [')', '('],
            [']', '[']);

        for (let i = 0; i < chars.length; i++) {
            let character = chars[i];

            if (character === '}'
                || character === ']'
                || character === ')') {
                if (stack.pop() !== braceMap.get(character)) {
                    return false;
                }
                size--;
            } else {
                stack[size++] = character;
            }
        }

        return size === 0;
    },
    brackets: ["}{[[[]]]}}", "[[]]"],
};

(function main(options) {

    for (let i = 0; i < options.brackets.length; i++) {
        console.log(options.isBalanced(options.brackets[i]));
    }

})(options);