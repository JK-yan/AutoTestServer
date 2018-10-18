import jwt.JwtUtil

def map=['userId':'admin']
def b= JwtUtil.create_token(map)
println(b)
sleep(2000)
def c=JwtUtil.parseJWT(b)
println(c)
println(c['userId'])