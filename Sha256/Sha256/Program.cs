using System;
using System.Text;
using System.Security.Cryptography;

namespace Sha256
{
    class Program
    {
        static void Main(string[] args)
        {
            var textToEncrypt = args[0];
            var dataToEncrypt = Encoding.UTF8.GetBytes(textToEncrypt);
            SHA256 shaM = new SHA256Managed();
            var encryptedData = shaM.ComputeHash(dataToEncrypt);
            var encryptedText = Convert.ToBase64String(encryptedData);
            Console.WriteLine(encryptedText);
        }
    }
}
