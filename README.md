# GameOfLife-
 conway's game of life console game -Java

---

<p>
  The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.
 <br> It is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. 
  <br>One interacts with the Game of Life by creating an initial configuration and observing how it evolves.
  <br>It is Turing complete and can simulate a universal constructor or any other Turing machine.
  </p>
  
  <p>
  <h5>Rules</h5>
  The universe of the Game of Life is an infinite, two-dimensional orthogonal grid of square cells,<br>
   each of which is in one of two possible states, live or dead, (or populated and unpopulated, respectively).<br>
   Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent.<br>
   <br>
   At each step in time, the following transitions occur:<br>
   <ol>
  <li>Any live cell with fewer than two live neighbours dies, as if by underpopulation.</li>
  <li>Any live cell with two or three live neighbours lives on to the next generation.</li>
  <li>Any live cell with more than three live neighbours dies, as if by overpopulation.</li>
  <li>Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.</li>
  </ol>
  These rules, which compare the behavior of the automaton to real life, can be condensed into the following:<br>
  <ol>
  <li>Any live cell with two or three live neighbours survives.</li>
  <li>Any dead cell with three live neighbours becomes a live cell.</li>
  <li>All other live cells die in the next generation. Similarly, all other dead cells stay dead.</li>
  </ol>
  The initial pattern constitutes the seed of the system.<br>
  The first generation is created by applying the above rules simultaneously to every cell in the seed;<br>
  births and deaths occur simultaneously, and the discrete moment at which this happens is sometimes called a tick.<br>
  Each generation is a pure function of the preceding one.<br>
  The rules continue to be applied repeatedly to create further generations.
  <br>
  <br>
  <i>
  For more infortmation: 
  https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
</i>
</p>
<br>
![alt text](https://github.com/maoz-grossman/GameOfLife-/blob/master/Images/output_lgDqWb.gif?raw=true)
