package jwt

def map=['userId':'admin']
def b=JwtUtil.create_token(map)
println(b)
def c=JwtUtil.parseJWT(b)
println(c)
println(c['userId'])
