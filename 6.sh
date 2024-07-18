<!-----save file name in app.py------>
from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/')
def index():
    return '''
        <html>
            <body>
                <h2>Convert Fahrenheit to Celsius</h2>
                <form action="/convert" method="post">
                    <label for="fahrenheit">Temperature in Fahrenheit:</label><br><br>
                    <input type="text" id="fahrenheit" name="fahrenheit"><br><br>
                    <input type="submit" value="Convert">
                </form>
            </body>
        </html>
    '''

@app.route('/convert', methods=['POST'])
def convert():
    try:
        fahrenheit = float(request.form['fahrenheit'])
        celsius = (fahrenheit - 32) * 5.0/9.0
        return jsonify({
            'fahrenheit': fahrenheit,
            'celsius': celsius
        })
    except ValueError:
        return jsonify({
            'error': 'Invalid input. Please enter a valid number for Fahrenheit.'
        }), 400

if __name__ == '__main__':
    app.run(debug=True)
<!---step1:create virtual environment in vs code terminal
python -m venv myenv

step2: goto command promt goto current path
cd C:\Users\Sharma Rao\Desktop\test

step3:activate the created virtual environment
myenv\Scripts\activate

step4:install flask in created environment
pip install flask

step5:run the application using flak
flask --app app run

step6:copy paste the http to browser
http://127.0.0.1:5000   ---->