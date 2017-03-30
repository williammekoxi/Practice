using System;
using System.Collections.Generic;
using System.DirectoryServices;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ad
{
    class Program
    {
        static void Main(string[] args)
        {
            var properties = new List<string> { "name", "givenName", "samaccountname", "mail", };
            var entry = new DirectoryEntry("LDAP://huazhu.com");
            var searcher = new DirectorySearcher(entry)
            {
                Filter = "(samaccountname=huangshenghui)",
            };
            properties.ForEach(p => searcher.PropertiesToLoad.Add(p));
            var result = searcher.FindOne();
            if (result != null)
            {
                properties.ForEach(p => result.Properties[p].Cast<ResultPropertyValueCollection>().ToList().ForEach(values => values.Cast<object>().ToList().ForEach(value => Console.WriteLine("{0}: {1}", p, value))));
            }
        }
    }
}
