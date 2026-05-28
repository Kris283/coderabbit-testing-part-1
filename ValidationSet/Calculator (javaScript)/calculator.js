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

        const safeInputPattern = /^[0-9+\-*/().\s]+$/;

        if (!safeInputPattern.test(input)) {
            console.log("\n[!] SECURITY VIOLATION: Invalid characters detected.");
            console.log("Only numbers and basic math operators are allowed.");
        } else {
            try {
                // 2. If it passes the strict check, it is safe to evaluate.
                // Note: Using a dedicated math parser library is still preferred over eval() or Function().
                const result = new Function(`return ${input}`)();
                console.log(`Result: ${result}`);
            } catch (err) {
                console.log(`Error evaluating expression: ${err.message}`);
            }
        }
        
        askQuestion();
    });
}

askQuestion();
