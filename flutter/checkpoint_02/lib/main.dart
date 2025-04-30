import 'package:flutter/material.dart';

// Integrantes
// José Roberto Claudino Ferreira - RM 552407
// Nicolas Machado                - RM 552493

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Github',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.white),
      ),
      home: const Menu(),
    );
  }
}

class Menu extends StatelessWidget {
  const Menu({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: [
            UserAccountsDrawerHeader(
              decoration: const BoxDecoration(color: Colors.grey),
              accountName: const Text("Nicolas e José"),
              accountEmail: const Text("nizé_aqué@gmail.com"),
              currentAccountPicture: CircleAvatar(
                backgroundImage: NetworkImage(
                  "https://avatars.githubusercontent.com/u/12345678?v=4",
                ),
              ),
            ),

            ListTile(
              title: const Text('Perfil'),
              leading: const Icon(Icons.person),
              onTap: () {},
            ),
            ListTile(
              title: const Text('Repositórios'),
              leading: const Icon(Icons.book),
              onTap: () {},
            ),
            ListTile(
              title: const Text('Favoritos'),
              leading: const Icon(Icons.star),
              onTap: () {},
            ),
          ],
        ),
      ),
      appBar: AppBar(
        title: Row(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            const SizedBox(width: 10),
            const Text(
              "Github Profile",
              style: TextStyle(
                color: Colors.white,
                fontSize: 20,
                fontWeight: FontWeight.bold,
              ),
            ),
          ],
        ),
        backgroundColor: Colors.grey,
      ),
      body: Center(
        child: Container(
          height: 400,
          child: Column(
            children: [
              CircleAvatar(
                radius: 50,
                backgroundImage: NetworkImage(
                  "https://avatars.githubusercontent.com/u/12345678?v=4",
                ),
              ),
              Text(
                "Nicolas e José",
                style: TextStyle(
                  fontSize: 28,
                  fontWeight: FontWeight.bold,
                  color: Colors.black,
                ),
              ),
              Text(
                "nizé_aqué",
                style: TextStyle(fontSize: 16, color: Colors.grey),
              ),
              // adicione com ícones e widgets separados localização, email, seguidores e seguindo
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(Icons.map, color: Colors.grey),
                  SizedBox(width: 5),
                  Text(
                    "Brazil, São Paulo, SP",
                    style: TextStyle(color: Colors.grey),
                  ),
                ],
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(Icons.email, color: Colors.grey),
                  SizedBox(width: 5),
                  Text(
                    "nicolas_ze@gmail.com",
                    style: TextStyle(color: Colors.grey),
                  ),
                ],
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(Icons.people, color: Colors.grey),
                  SizedBox(width: 5),
                  Text(
                    "1242",
                    style: TextStyle(
                      color: Colors.grey,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  SizedBox(width: 5),
                  Text("seguidores", style: TextStyle(color: Colors.grey)),
                  SizedBox(width: 10),
                  Text(
                    "15",
                    style: TextStyle(
                      color: Colors.grey,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  SizedBox(width: 5),
                  Text("seguindo", style: TextStyle(color: Colors.grey)),
                ],
              ),
            ],
          ),
          // children: [
          //   Expanded(
          //     child: SingleChildScrollView(
          //       child: Column(
          //         children: [].map((pizza) => Text('pizza: 1')).toList(),
          //       ),
          //     ),
          //   ),
          //   if (isOpen())
          //     Padding(
          //       padding: const EdgeInsets.all(12.0),
          //       child: ElevatedButton(
          //         onPressed: () {},
          //         child: Text("Order now!"),
          //       ),
          //     ),
          // ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        child: Icon(Icons.add, color: Colors.white, size: 30),
        backgroundColor: Colors.green,
        shape: const CircleBorder(),
      ),
    );
  }
}

// Integrantes
// José Roberto Claudino Ferreira - RM 552407
// Nicolas Machado                - RM 552493
