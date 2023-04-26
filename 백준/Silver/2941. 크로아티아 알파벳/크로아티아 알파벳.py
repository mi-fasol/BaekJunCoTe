calp = ["c=", 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
st = input()

for c in calp:
    st = st.replace(c, "*")

print(len(st))