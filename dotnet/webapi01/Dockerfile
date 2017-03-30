# Use the standard Microsoft .NET Core container
FROM microsoft/aspnetcore-build
 
# Copy our code from the "/src/MyWebApi" folder to the "/app" folder in our container
COPY . /app
WORKDIR /app
 
# Expose port 80 for the Web API traffic
ENV ASPNETCORE_URLS http://+:5000
EXPOSE 5000

# Restore the necessary packages
RUN ["dotnet", "restore"]
RUN ["dotnet", "build"]
 
# Build and run the dotnet application from within the container
ENTRYPOINT ["dotnet", "run"]
