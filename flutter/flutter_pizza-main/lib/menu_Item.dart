// ignore_for_file: prefer_const_constructors, prefer_const_literals_to_create_immutables

import 'package:app/pizza_data.dart';
import 'package:flutter/material.dart';

class MenuItem extends StatelessWidget {
  final Pizza pizza;
  const MenuItem({super.key, required this.pizza});

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 0,
      child: Padding(
        padding: EdgeInsets.all(12),
        child: (Row(
          children: [
            ColorFiltered(
              colorFilter: pizza.soldOut
                  ? ColorFilter.mode(Colors.grey, BlendMode.saturation)
                  : ColorFilter.mode(Colors.transparent, BlendMode.saturation),
              child: Image.asset(
                "images/${pizza.photoName}",
                width: 100,
                height: 100,
                fit: BoxFit.cover,
              ),
            ),
            SizedBox(
              width: 12,
            ),
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    pizza.name,
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 18,
                    ),
                  ),
                  Text(
                    pizza.ingredients,
                    style: TextStyle(fontSize: 16, color: Colors.black87),
                  ),
                  Text(
                    pizza.soldOut ? "sold out" : "\$${pizza.price}",
                    style: TextStyle(
                        fontSize: 16,
                        color: Colors.black54,
                        fontWeight: FontWeight.w500),
                  ),
                ],
              ),
            )
          ],
        )),
      ),
    );
  }
}
