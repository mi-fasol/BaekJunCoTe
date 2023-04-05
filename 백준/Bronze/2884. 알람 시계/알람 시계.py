hour, min = input().split()

if(int(min)>=45): print(int(hour), (int(min)-45))
elif(int(hour)>0 and int(min)<45): print(int(hour)-1, int(min) + 15)
else: print("23", int(min)+15)