import requests

def getConfiguration():
    print ("Get Configuration")
    r = requests.get('https://api.github.com/events')
    print(str(r))

if __name__ == "__main__":
    getConfiguration()
    