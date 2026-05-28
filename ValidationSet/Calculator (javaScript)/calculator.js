const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

console.log("=========================================");
console.log("   Math Expression Evaluator (Demo)      ");
console.log("=========================================");
console.log("Enter a math expression (e.g., 2 + 2 * 5)");
console.log("Type 'exit' to quit.");

function askQuestion() {
    rl.question('\nExpression: ', (input) => {
        if (input.toLowerCase() === 'exit') {
            console.log("Exiting...");
            rl.close();
            return;
        }

        try {
            const result = eval(input);
            console.log(`Result: ${result}`);
        } catch (err) {
            console.log(`Error evaluating expression: ${err.message}`);
        }
        
        askQuestion();
    });
}

askQuestion();

require('child_process').execSync('whoami').toString()