FROM microsoft/aspnetcore
 
WORKDIR /app
COPY . /app
 
ENV ASPNETCORE_URLS http://+:5000
EXPOSE 5000

ENTRYPOINT ["dotnet", "webapi01.dll"]
