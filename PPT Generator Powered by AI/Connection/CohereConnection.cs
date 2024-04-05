using System.Text;

namespace PPTGenerator.Connection
{
    internal class CohereConnection(string ApiKey)
    {
        private readonly HttpClient _client = new();
        private readonly string _bearerToken = ApiKey;

        public async Task<HttpResponseMessage> PostAsync(string uri, string jsonData)
        {
            var request = new HttpRequestMessage
            {
                Method = HttpMethod.Post,
                RequestUri = new Uri(uri),
                Content = new StringContent(jsonData, Encoding.UTF8, "application/json"),
                Headers =
            {
                { "accept", "application/json" },
                { "authorization", $"Bearer {_bearerToken}" },
            },
            };

            return await _client.SendAsync(request);
        }
    }
}
