from java.lang import System as sys_obj

def hello():
    "Some documentation annotation..."
    return "Hello World"

sys_obj.out.println(hello() + "!\n" + hello.__doc__)
