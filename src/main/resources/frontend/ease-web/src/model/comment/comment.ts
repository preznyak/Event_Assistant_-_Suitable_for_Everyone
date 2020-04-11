import {User} from "../user/user";

export class Comment {
  commentId: bigint;
  commenter: User;
  message: string;
  date: Date;
}
