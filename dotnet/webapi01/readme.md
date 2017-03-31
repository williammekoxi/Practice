
### copy published files to publish folder
dotnet publish
cp -r ./bin/Debug/netcoreapp1.1/publish/* ./dockerpublish/
cp ./Dockerfile ./dockerpublish/

### docker build
cd ./dockerpublish
docker build -t williammeko/webapi01 .
cd ..

### docker run
docker run -p 80:5000 -t williammeko/webapi01


