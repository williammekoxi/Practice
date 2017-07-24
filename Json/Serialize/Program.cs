using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Serialize
{
    class Program
    {
        static void Main(string[] args)
        {
            var obj1 = new
            {
                a = "中\"文"
            };
            var obj2 = new
            {
                b = JsonConvert.SerializeObject(obj1).ToString()
            };

            string dd = JsonConvert.SerializeObject(obj2).ToString();
            var obj3 = new
            {
                c = JsonConvert.SerializeObject(dd)
            };

            var j3 = JsonConvert.SerializeObject(obj3);
            Console.WriteLine(j3);
            dynamic o3 = JsonConvert.DeserializeObject(j3);
            dynamic o2 = JsonConvert.DeserializeObject((string)o3.c);
            dynamic o1 = JsonConvert.DeserializeObject((string)o2.b);
            Console.WriteLine(o1.a);
            Console.ReadKey();
        }
    }
}
