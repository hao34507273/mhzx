/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class RecallFriendBackGame extends XBean implements xbean.RecallFriendBackGame
/*      */ {
/*      */   private ArrayList<xbean.RecallUserInfo> recall_friend_list;
/*      */   private int recall_friend_num;
/*      */   private long last_recall_friend_time;
/*      */   private int recall_friend_times_today;
/*      */   private int recall_friend_num_award_serial_no;
/*      */   private xbean.BeRecalledBackGameInfo be_recalled_back_game;
/*      */   private xbean.RebateInfo rebate_info;
/*      */   private int cross_recall_friend_times_today;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.recall_friend_list.clear();
/*   33 */     this.recall_friend_num = 0;
/*   34 */     this.last_recall_friend_time = 0L;
/*   35 */     this.recall_friend_times_today = 0;
/*   36 */     this.recall_friend_num_award_serial_no = 0;
/*   37 */     this.be_recalled_back_game._reset_unsafe_();
/*   38 */     this.rebate_info._reset_unsafe_();
/*   39 */     this.cross_recall_friend_times_today = 0;
/*      */   }
/*      */   
/*      */   RecallFriendBackGame(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.recall_friend_list = new ArrayList();
/*   46 */     this.be_recalled_back_game = new BeRecalledBackGameInfo(0, this, "be_recalled_back_game");
/*   47 */     this.rebate_info = new RebateInfo(0, this, "rebate_info");
/*      */   }
/*      */   
/*      */   public RecallFriendBackGame()
/*      */   {
/*   52 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RecallFriendBackGame(RecallFriendBackGame _o_)
/*      */   {
/*   57 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RecallFriendBackGame(xbean.RecallFriendBackGame _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   62 */     super(_xp_, _vn_);
/*   63 */     if ((_o1_ instanceof RecallFriendBackGame)) { assign((RecallFriendBackGame)_o1_);
/*   64 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   65 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   66 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RecallFriendBackGame _o_) {
/*   71 */     _o_._xdb_verify_unsafe_();
/*   72 */     this.recall_friend_list = new ArrayList();
/*   73 */     for (xbean.RecallUserInfo _v_ : _o_.recall_friend_list)
/*   74 */       this.recall_friend_list.add(new RecallUserInfo(_v_, this, "recall_friend_list"));
/*   75 */     this.recall_friend_num = _o_.recall_friend_num;
/*   76 */     this.last_recall_friend_time = _o_.last_recall_friend_time;
/*   77 */     this.recall_friend_times_today = _o_.recall_friend_times_today;
/*   78 */     this.recall_friend_num_award_serial_no = _o_.recall_friend_num_award_serial_no;
/*   79 */     this.be_recalled_back_game = new BeRecalledBackGameInfo(_o_.be_recalled_back_game, this, "be_recalled_back_game");
/*   80 */     this.rebate_info = new RebateInfo(_o_.rebate_info, this, "rebate_info");
/*   81 */     this.cross_recall_friend_times_today = _o_.cross_recall_friend_times_today;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   86 */     this.recall_friend_list = new ArrayList();
/*   87 */     for (xbean.RecallUserInfo _v_ : _o_.recall_friend_list)
/*   88 */       this.recall_friend_list.add(new RecallUserInfo(_v_, this, "recall_friend_list"));
/*   89 */     this.recall_friend_num = _o_.recall_friend_num;
/*   90 */     this.last_recall_friend_time = _o_.last_recall_friend_time;
/*   91 */     this.recall_friend_times_today = _o_.recall_friend_times_today;
/*   92 */     this.recall_friend_num_award_serial_no = _o_.recall_friend_num_award_serial_no;
/*   93 */     this.be_recalled_back_game = new BeRecalledBackGameInfo(_o_.be_recalled_back_game, this, "be_recalled_back_game");
/*   94 */     this.rebate_info = new RebateInfo(_o_.rebate_info, this, "rebate_info");
/*   95 */     this.cross_recall_friend_times_today = _o_.cross_recall_friend_times_today;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  101 */     _xdb_verify_unsafe_();
/*  102 */     _os_.compact_uint32(this.recall_friend_list.size());
/*  103 */     for (xbean.RecallUserInfo _v_ : this.recall_friend_list)
/*      */     {
/*  105 */       _v_.marshal(_os_);
/*      */     }
/*  107 */     _os_.marshal(this.recall_friend_num);
/*  108 */     _os_.marshal(this.last_recall_friend_time);
/*  109 */     _os_.marshal(this.recall_friend_times_today);
/*  110 */     _os_.marshal(this.recall_friend_num_award_serial_no);
/*  111 */     this.be_recalled_back_game.marshal(_os_);
/*  112 */     this.rebate_info.marshal(_os_);
/*  113 */     _os_.marshal(this.cross_recall_friend_times_today);
/*  114 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  120 */     _xdb_verify_unsafe_();
/*  121 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  123 */       xbean.RecallUserInfo _v_ = new RecallUserInfo(0, this, "recall_friend_list");
/*  124 */       _v_.unmarshal(_os_);
/*  125 */       this.recall_friend_list.add(_v_);
/*      */     }
/*  127 */     this.recall_friend_num = _os_.unmarshal_int();
/*  128 */     this.last_recall_friend_time = _os_.unmarshal_long();
/*  129 */     this.recall_friend_times_today = _os_.unmarshal_int();
/*  130 */     this.recall_friend_num_award_serial_no = _os_.unmarshal_int();
/*  131 */     this.be_recalled_back_game.unmarshal(_os_);
/*  132 */     this.rebate_info.unmarshal(_os_);
/*  133 */     this.cross_recall_friend_times_today = _os_.unmarshal_int();
/*  134 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*  141 */     int _size_ = 0;
/*  142 */     for (xbean.RecallUserInfo _v_ : this.recall_friend_list)
/*      */     {
/*  144 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */     }
/*  146 */     _size_ += CodedOutputStream.computeInt32Size(2, this.recall_friend_num);
/*  147 */     _size_ += CodedOutputStream.computeInt64Size(3, this.last_recall_friend_time);
/*  148 */     _size_ += CodedOutputStream.computeInt32Size(4, this.recall_friend_times_today);
/*  149 */     _size_ += CodedOutputStream.computeInt32Size(5, this.recall_friend_num_award_serial_no);
/*  150 */     _size_ += CodedOutputStream.computeMessageSize(6, this.be_recalled_back_game);
/*  151 */     _size_ += CodedOutputStream.computeMessageSize(7, this.rebate_info);
/*  152 */     _size_ += CodedOutputStream.computeInt32Size(8, this.cross_recall_friend_times_today);
/*  153 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  159 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  162 */       for (xbean.RecallUserInfo _v_ : this.recall_friend_list)
/*      */       {
/*  164 */         _output_.writeMessage(1, _v_);
/*      */       }
/*  166 */       _output_.writeInt32(2, this.recall_friend_num);
/*  167 */       _output_.writeInt64(3, this.last_recall_friend_time);
/*  168 */       _output_.writeInt32(4, this.recall_friend_times_today);
/*  169 */       _output_.writeInt32(5, this.recall_friend_num_award_serial_no);
/*  170 */       _output_.writeMessage(6, this.be_recalled_back_game);
/*  171 */       _output_.writeMessage(7, this.rebate_info);
/*  172 */       _output_.writeInt32(8, this.cross_recall_friend_times_today);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  176 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  178 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  184 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  187 */       boolean done = false;
/*  188 */       while (!done)
/*      */       {
/*  190 */         int tag = _input_.readTag();
/*  191 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  195 */           done = true;
/*  196 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  200 */           xbean.RecallUserInfo _v_ = new RecallUserInfo(0, this, "recall_friend_list");
/*  201 */           _input_.readMessage(_v_);
/*  202 */           this.recall_friend_list.add(_v_);
/*  203 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  207 */           this.recall_friend_num = _input_.readInt32();
/*  208 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  212 */           this.last_recall_friend_time = _input_.readInt64();
/*  213 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  217 */           this.recall_friend_times_today = _input_.readInt32();
/*  218 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  222 */           this.recall_friend_num_award_serial_no = _input_.readInt32();
/*  223 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  227 */           _input_.readMessage(this.be_recalled_back_game);
/*  228 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  232 */           _input_.readMessage(this.rebate_info);
/*  233 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  237 */           this.cross_recall_friend_times_today = _input_.readInt32();
/*  238 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  242 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  244 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  253 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  257 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  259 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RecallFriendBackGame copy()
/*      */   {
/*  265 */     _xdb_verify_unsafe_();
/*  266 */     return new RecallFriendBackGame(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RecallFriendBackGame toData()
/*      */   {
/*  272 */     _xdb_verify_unsafe_();
/*  273 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RecallFriendBackGame toBean()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return new RecallFriendBackGame(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RecallFriendBackGame toDataIf()
/*      */   {
/*  285 */     _xdb_verify_unsafe_();
/*  286 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RecallFriendBackGame toBeanIf()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  298 */     _xdb_verify_unsafe_();
/*  299 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.RecallUserInfo> getRecall_friend_list()
/*      */   {
/*  306 */     _xdb_verify_unsafe_();
/*  307 */     return Logs.logList(new LogKey(this, "recall_friend_list"), this.recall_friend_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.RecallUserInfo> getRecall_friend_listAsData()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*      */     
/*  315 */     RecallFriendBackGame _o_ = this;
/*  316 */     List<xbean.RecallUserInfo> recall_friend_list = new ArrayList();
/*  317 */     for (xbean.RecallUserInfo _v_ : _o_.recall_friend_list)
/*  318 */       recall_friend_list.add(new RecallUserInfo.Data(_v_));
/*  319 */     return recall_friend_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRecall_friend_num()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.recall_friend_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_recall_friend_time()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return this.last_recall_friend_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRecall_friend_times_today()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return this.recall_friend_times_today;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRecall_friend_num_award_serial_no()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return this.recall_friend_num_award_serial_no;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.BeRecalledBackGameInfo getBe_recalled_back_game()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return this.be_recalled_back_game;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.RebateInfo getRebate_info()
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     return this.rebate_info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCross_recall_friend_times_today()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     return this.cross_recall_friend_times_today;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecall_friend_num(int _v_)
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     Logs.logIf(new LogKey(this, "recall_friend_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  387 */         new LogInt(this, RecallFriendBackGame.this.recall_friend_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  391 */             RecallFriendBackGame.this.recall_friend_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  395 */     });
/*  396 */     this.recall_friend_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_recall_friend_time(long _v_)
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*  404 */     Logs.logIf(new LogKey(this, "last_recall_friend_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  408 */         new xdb.logs.LogLong(this, RecallFriendBackGame.this.last_recall_friend_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  412 */             RecallFriendBackGame.this.last_recall_friend_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  416 */     });
/*  417 */     this.last_recall_friend_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecall_friend_times_today(int _v_)
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     Logs.logIf(new LogKey(this, "recall_friend_times_today")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  429 */         new LogInt(this, RecallFriendBackGame.this.recall_friend_times_today)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  433 */             RecallFriendBackGame.this.recall_friend_times_today = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  437 */     });
/*  438 */     this.recall_friend_times_today = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecall_friend_num_award_serial_no(int _v_)
/*      */   {
/*  445 */     _xdb_verify_unsafe_();
/*  446 */     Logs.logIf(new LogKey(this, "recall_friend_num_award_serial_no")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  450 */         new LogInt(this, RecallFriendBackGame.this.recall_friend_num_award_serial_no)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  454 */             RecallFriendBackGame.this.recall_friend_num_award_serial_no = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  458 */     });
/*  459 */     this.recall_friend_num_award_serial_no = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCross_recall_friend_times_today(int _v_)
/*      */   {
/*  466 */     _xdb_verify_unsafe_();
/*  467 */     Logs.logIf(new LogKey(this, "cross_recall_friend_times_today")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  471 */         new LogInt(this, RecallFriendBackGame.this.cross_recall_friend_times_today)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  475 */             RecallFriendBackGame.this.cross_recall_friend_times_today = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  479 */     });
/*  480 */     this.cross_recall_friend_times_today = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  486 */     _xdb_verify_unsafe_();
/*  487 */     RecallFriendBackGame _o_ = null;
/*  488 */     if ((_o1_ instanceof RecallFriendBackGame)) { _o_ = (RecallFriendBackGame)_o1_;
/*  489 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  490 */       return false;
/*  491 */     if (!this.recall_friend_list.equals(_o_.recall_friend_list)) return false;
/*  492 */     if (this.recall_friend_num != _o_.recall_friend_num) return false;
/*  493 */     if (this.last_recall_friend_time != _o_.last_recall_friend_time) return false;
/*  494 */     if (this.recall_friend_times_today != _o_.recall_friend_times_today) return false;
/*  495 */     if (this.recall_friend_num_award_serial_no != _o_.recall_friend_num_award_serial_no) return false;
/*  496 */     if (!this.be_recalled_back_game.equals(_o_.be_recalled_back_game)) return false;
/*  497 */     if (!this.rebate_info.equals(_o_.rebate_info)) return false;
/*  498 */     if (this.cross_recall_friend_times_today != _o_.cross_recall_friend_times_today) return false;
/*  499 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     int _h_ = 0;
/*  507 */     _h_ += this.recall_friend_list.hashCode();
/*  508 */     _h_ += this.recall_friend_num;
/*  509 */     _h_ = (int)(_h_ + this.last_recall_friend_time);
/*  510 */     _h_ += this.recall_friend_times_today;
/*  511 */     _h_ += this.recall_friend_num_award_serial_no;
/*  512 */     _h_ += this.be_recalled_back_game.hashCode();
/*  513 */     _h_ += this.rebate_info.hashCode();
/*  514 */     _h_ += this.cross_recall_friend_times_today;
/*  515 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  521 */     _xdb_verify_unsafe_();
/*  522 */     StringBuilder _sb_ = new StringBuilder();
/*  523 */     _sb_.append("(");
/*  524 */     _sb_.append(this.recall_friend_list);
/*  525 */     _sb_.append(",");
/*  526 */     _sb_.append(this.recall_friend_num);
/*  527 */     _sb_.append(",");
/*  528 */     _sb_.append(this.last_recall_friend_time);
/*  529 */     _sb_.append(",");
/*  530 */     _sb_.append(this.recall_friend_times_today);
/*  531 */     _sb_.append(",");
/*  532 */     _sb_.append(this.recall_friend_num_award_serial_no);
/*  533 */     _sb_.append(",");
/*  534 */     _sb_.append(this.be_recalled_back_game);
/*  535 */     _sb_.append(",");
/*  536 */     _sb_.append(this.rebate_info);
/*  537 */     _sb_.append(",");
/*  538 */     _sb_.append(this.cross_recall_friend_times_today);
/*  539 */     _sb_.append(")");
/*  540 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  546 */     ListenableBean lb = new ListenableBean();
/*  547 */     lb.add(new ListenableChanged().setVarName("recall_friend_list"));
/*  548 */     lb.add(new ListenableChanged().setVarName("recall_friend_num"));
/*  549 */     lb.add(new ListenableChanged().setVarName("last_recall_friend_time"));
/*  550 */     lb.add(new ListenableChanged().setVarName("recall_friend_times_today"));
/*  551 */     lb.add(new ListenableChanged().setVarName("recall_friend_num_award_serial_no"));
/*  552 */     lb.add(new ListenableChanged().setVarName("be_recalled_back_game"));
/*  553 */     lb.add(new ListenableChanged().setVarName("rebate_info"));
/*  554 */     lb.add(new ListenableChanged().setVarName("cross_recall_friend_times_today"));
/*  555 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RecallFriendBackGame {
/*      */     private Const() {}
/*      */     
/*      */     RecallFriendBackGame nThis() {
/*  562 */       return RecallFriendBackGame.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  568 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallFriendBackGame copy()
/*      */     {
/*  574 */       return RecallFriendBackGame.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallFriendBackGame toData()
/*      */     {
/*  580 */       return RecallFriendBackGame.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RecallFriendBackGame toBean()
/*      */     {
/*  585 */       return RecallFriendBackGame.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallFriendBackGame toDataIf()
/*      */     {
/*  591 */       return RecallFriendBackGame.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RecallFriendBackGame toBeanIf()
/*      */     {
/*  596 */       return RecallFriendBackGame.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.RecallUserInfo> getRecall_friend_list()
/*      */     {
/*  603 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  604 */       return xdb.Consts.constList(RecallFriendBackGame.this.recall_friend_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.RecallUserInfo> getRecall_friend_listAsData()
/*      */     {
/*  610 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*      */       
/*  612 */       RecallFriendBackGame _o_ = RecallFriendBackGame.this;
/*  613 */       List<xbean.RecallUserInfo> recall_friend_list = new ArrayList();
/*  614 */       for (xbean.RecallUserInfo _v_ : _o_.recall_friend_list)
/*  615 */         recall_friend_list.add(new RecallUserInfo.Data(_v_));
/*  616 */       return recall_friend_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecall_friend_num()
/*      */     {
/*  623 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  624 */       return RecallFriendBackGame.this.recall_friend_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_recall_friend_time()
/*      */     {
/*  631 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  632 */       return RecallFriendBackGame.this.last_recall_friend_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecall_friend_times_today()
/*      */     {
/*  639 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  640 */       return RecallFriendBackGame.this.recall_friend_times_today;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecall_friend_num_award_serial_no()
/*      */     {
/*  647 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  648 */       return RecallFriendBackGame.this.recall_friend_num_award_serial_no;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.BeRecalledBackGameInfo getBe_recalled_back_game()
/*      */     {
/*  655 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  656 */       return (xbean.BeRecalledBackGameInfo)xdb.Consts.toConst(RecallFriendBackGame.this.be_recalled_back_game);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.RebateInfo getRebate_info()
/*      */     {
/*  663 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  664 */       return (xbean.RebateInfo)xdb.Consts.toConst(RecallFriendBackGame.this.rebate_info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCross_recall_friend_times_today()
/*      */     {
/*  671 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  672 */       return RecallFriendBackGame.this.cross_recall_friend_times_today;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_friend_num(int _v_)
/*      */     {
/*  679 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  680 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_recall_friend_time(long _v_)
/*      */     {
/*  687 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  688 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_friend_times_today(int _v_)
/*      */     {
/*  695 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  696 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_friend_num_award_serial_no(int _v_)
/*      */     {
/*  703 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  704 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCross_recall_friend_times_today(int _v_)
/*      */     {
/*  711 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  712 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  718 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  719 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  725 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  726 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  732 */       return RecallFriendBackGame.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  738 */       return RecallFriendBackGame.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  744 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  745 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  751 */       return RecallFriendBackGame.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  757 */       return RecallFriendBackGame.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  763 */       RecallFriendBackGame.this._xdb_verify_unsafe_();
/*  764 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  770 */       return RecallFriendBackGame.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  776 */       return RecallFriendBackGame.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  782 */       return RecallFriendBackGame.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  788 */       return RecallFriendBackGame.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  794 */       return RecallFriendBackGame.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  800 */       return RecallFriendBackGame.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  806 */       return RecallFriendBackGame.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RecallFriendBackGame
/*      */   {
/*      */     private ArrayList<xbean.RecallUserInfo> recall_friend_list;
/*      */     
/*      */     private int recall_friend_num;
/*      */     
/*      */     private long last_recall_friend_time;
/*      */     
/*      */     private int recall_friend_times_today;
/*      */     
/*      */     private int recall_friend_num_award_serial_no;
/*      */     
/*      */     private xbean.BeRecalledBackGameInfo be_recalled_back_game;
/*      */     
/*      */     private xbean.RebateInfo rebate_info;
/*      */     
/*      */     private int cross_recall_friend_times_today;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  832 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  837 */       this.recall_friend_list = new ArrayList();
/*  838 */       this.be_recalled_back_game = new BeRecalledBackGameInfo.Data();
/*  839 */       this.rebate_info = new RebateInfo.Data();
/*      */     }
/*      */     
/*      */     Data(xbean.RecallFriendBackGame _o1_)
/*      */     {
/*  844 */       if ((_o1_ instanceof RecallFriendBackGame)) { assign((RecallFriendBackGame)_o1_);
/*  845 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  846 */       } else if ((_o1_ instanceof RecallFriendBackGame.Const)) assign(((RecallFriendBackGame.Const)_o1_).nThis()); else {
/*  847 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RecallFriendBackGame _o_) {
/*  852 */       this.recall_friend_list = new ArrayList();
/*  853 */       for (xbean.RecallUserInfo _v_ : _o_.recall_friend_list)
/*  854 */         this.recall_friend_list.add(new RecallUserInfo.Data(_v_));
/*  855 */       this.recall_friend_num = _o_.recall_friend_num;
/*  856 */       this.last_recall_friend_time = _o_.last_recall_friend_time;
/*  857 */       this.recall_friend_times_today = _o_.recall_friend_times_today;
/*  858 */       this.recall_friend_num_award_serial_no = _o_.recall_friend_num_award_serial_no;
/*  859 */       this.be_recalled_back_game = new BeRecalledBackGameInfo.Data(_o_.be_recalled_back_game);
/*  860 */       this.rebate_info = new RebateInfo.Data(_o_.rebate_info);
/*  861 */       this.cross_recall_friend_times_today = _o_.cross_recall_friend_times_today;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  866 */       this.recall_friend_list = new ArrayList();
/*  867 */       for (xbean.RecallUserInfo _v_ : _o_.recall_friend_list)
/*  868 */         this.recall_friend_list.add(new RecallUserInfo.Data(_v_));
/*  869 */       this.recall_friend_num = _o_.recall_friend_num;
/*  870 */       this.last_recall_friend_time = _o_.last_recall_friend_time;
/*  871 */       this.recall_friend_times_today = _o_.recall_friend_times_today;
/*  872 */       this.recall_friend_num_award_serial_no = _o_.recall_friend_num_award_serial_no;
/*  873 */       this.be_recalled_back_game = new BeRecalledBackGameInfo.Data(_o_.be_recalled_back_game);
/*  874 */       this.rebate_info = new RebateInfo.Data(_o_.rebate_info);
/*  875 */       this.cross_recall_friend_times_today = _o_.cross_recall_friend_times_today;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  881 */       _os_.compact_uint32(this.recall_friend_list.size());
/*  882 */       for (xbean.RecallUserInfo _v_ : this.recall_friend_list)
/*      */       {
/*  884 */         _v_.marshal(_os_);
/*      */       }
/*  886 */       _os_.marshal(this.recall_friend_num);
/*  887 */       _os_.marshal(this.last_recall_friend_time);
/*  888 */       _os_.marshal(this.recall_friend_times_today);
/*  889 */       _os_.marshal(this.recall_friend_num_award_serial_no);
/*  890 */       this.be_recalled_back_game.marshal(_os_);
/*  891 */       this.rebate_info.marshal(_os_);
/*  892 */       _os_.marshal(this.cross_recall_friend_times_today);
/*  893 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  899 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  901 */         xbean.RecallUserInfo _v_ = xbean.Pod.newRecallUserInfoData();
/*  902 */         _v_.unmarshal(_os_);
/*  903 */         this.recall_friend_list.add(_v_);
/*      */       }
/*  905 */       this.recall_friend_num = _os_.unmarshal_int();
/*  906 */       this.last_recall_friend_time = _os_.unmarshal_long();
/*  907 */       this.recall_friend_times_today = _os_.unmarshal_int();
/*  908 */       this.recall_friend_num_award_serial_no = _os_.unmarshal_int();
/*  909 */       this.be_recalled_back_game.unmarshal(_os_);
/*  910 */       this.rebate_info.unmarshal(_os_);
/*  911 */       this.cross_recall_friend_times_today = _os_.unmarshal_int();
/*  912 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  918 */       int _size_ = 0;
/*  919 */       for (xbean.RecallUserInfo _v_ : this.recall_friend_list)
/*      */       {
/*  921 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */       }
/*  923 */       _size_ += CodedOutputStream.computeInt32Size(2, this.recall_friend_num);
/*  924 */       _size_ += CodedOutputStream.computeInt64Size(3, this.last_recall_friend_time);
/*  925 */       _size_ += CodedOutputStream.computeInt32Size(4, this.recall_friend_times_today);
/*  926 */       _size_ += CodedOutputStream.computeInt32Size(5, this.recall_friend_num_award_serial_no);
/*  927 */       _size_ += CodedOutputStream.computeMessageSize(6, this.be_recalled_back_game);
/*  928 */       _size_ += CodedOutputStream.computeMessageSize(7, this.rebate_info);
/*  929 */       _size_ += CodedOutputStream.computeInt32Size(8, this.cross_recall_friend_times_today);
/*  930 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  938 */         for (xbean.RecallUserInfo _v_ : this.recall_friend_list)
/*      */         {
/*  940 */           _output_.writeMessage(1, _v_);
/*      */         }
/*  942 */         _output_.writeInt32(2, this.recall_friend_num);
/*  943 */         _output_.writeInt64(3, this.last_recall_friend_time);
/*  944 */         _output_.writeInt32(4, this.recall_friend_times_today);
/*  945 */         _output_.writeInt32(5, this.recall_friend_num_award_serial_no);
/*  946 */         _output_.writeMessage(6, this.be_recalled_back_game);
/*  947 */         _output_.writeMessage(7, this.rebate_info);
/*  948 */         _output_.writeInt32(8, this.cross_recall_friend_times_today);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  952 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  954 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  962 */         boolean done = false;
/*  963 */         while (!done)
/*      */         {
/*  965 */           int tag = _input_.readTag();
/*  966 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  970 */             done = true;
/*  971 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/*  975 */             xbean.RecallUserInfo _v_ = xbean.Pod.newRecallUserInfoData();
/*  976 */             _input_.readMessage(_v_);
/*  977 */             this.recall_friend_list.add(_v_);
/*  978 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  982 */             this.recall_friend_num = _input_.readInt32();
/*  983 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  987 */             this.last_recall_friend_time = _input_.readInt64();
/*  988 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  992 */             this.recall_friend_times_today = _input_.readInt32();
/*  993 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  997 */             this.recall_friend_num_award_serial_no = _input_.readInt32();
/*  998 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/* 1002 */             _input_.readMessage(this.be_recalled_back_game);
/* 1003 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1007 */             _input_.readMessage(this.rebate_info);
/* 1008 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1012 */             this.cross_recall_friend_times_today = _input_.readInt32();
/* 1013 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1017 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1019 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1028 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1032 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1034 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallFriendBackGame copy()
/*      */     {
/* 1040 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallFriendBackGame toData()
/*      */     {
/* 1046 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RecallFriendBackGame toBean()
/*      */     {
/* 1051 */       return new RecallFriendBackGame(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallFriendBackGame toDataIf()
/*      */     {
/* 1057 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RecallFriendBackGame toBeanIf()
/*      */     {
/* 1062 */       return new RecallFriendBackGame(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1068 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1072 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1076 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1080 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1084 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1088 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1092 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.RecallUserInfo> getRecall_friend_list()
/*      */     {
/* 1099 */       return this.recall_friend_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.RecallUserInfo> getRecall_friend_listAsData()
/*      */     {
/* 1106 */       return this.recall_friend_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecall_friend_num()
/*      */     {
/* 1113 */       return this.recall_friend_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_recall_friend_time()
/*      */     {
/* 1120 */       return this.last_recall_friend_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecall_friend_times_today()
/*      */     {
/* 1127 */       return this.recall_friend_times_today;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecall_friend_num_award_serial_no()
/*      */     {
/* 1134 */       return this.recall_friend_num_award_serial_no;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.BeRecalledBackGameInfo getBe_recalled_back_game()
/*      */     {
/* 1141 */       return this.be_recalled_back_game;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.RebateInfo getRebate_info()
/*      */     {
/* 1148 */       return this.rebate_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCross_recall_friend_times_today()
/*      */     {
/* 1155 */       return this.cross_recall_friend_times_today;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_friend_num(int _v_)
/*      */     {
/* 1162 */       this.recall_friend_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_recall_friend_time(long _v_)
/*      */     {
/* 1169 */       this.last_recall_friend_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_friend_times_today(int _v_)
/*      */     {
/* 1176 */       this.recall_friend_times_today = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_friend_num_award_serial_no(int _v_)
/*      */     {
/* 1183 */       this.recall_friend_num_award_serial_no = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCross_recall_friend_times_today(int _v_)
/*      */     {
/* 1190 */       this.cross_recall_friend_times_today = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1196 */       if (!(_o1_ instanceof Data)) return false;
/* 1197 */       Data _o_ = (Data)_o1_;
/* 1198 */       if (!this.recall_friend_list.equals(_o_.recall_friend_list)) return false;
/* 1199 */       if (this.recall_friend_num != _o_.recall_friend_num) return false;
/* 1200 */       if (this.last_recall_friend_time != _o_.last_recall_friend_time) return false;
/* 1201 */       if (this.recall_friend_times_today != _o_.recall_friend_times_today) return false;
/* 1202 */       if (this.recall_friend_num_award_serial_no != _o_.recall_friend_num_award_serial_no) return false;
/* 1203 */       if (!this.be_recalled_back_game.equals(_o_.be_recalled_back_game)) return false;
/* 1204 */       if (!this.rebate_info.equals(_o_.rebate_info)) return false;
/* 1205 */       if (this.cross_recall_friend_times_today != _o_.cross_recall_friend_times_today) return false;
/* 1206 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1212 */       int _h_ = 0;
/* 1213 */       _h_ += this.recall_friend_list.hashCode();
/* 1214 */       _h_ += this.recall_friend_num;
/* 1215 */       _h_ = (int)(_h_ + this.last_recall_friend_time);
/* 1216 */       _h_ += this.recall_friend_times_today;
/* 1217 */       _h_ += this.recall_friend_num_award_serial_no;
/* 1218 */       _h_ += this.be_recalled_back_game.hashCode();
/* 1219 */       _h_ += this.rebate_info.hashCode();
/* 1220 */       _h_ += this.cross_recall_friend_times_today;
/* 1221 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1227 */       StringBuilder _sb_ = new StringBuilder();
/* 1228 */       _sb_.append("(");
/* 1229 */       _sb_.append(this.recall_friend_list);
/* 1230 */       _sb_.append(",");
/* 1231 */       _sb_.append(this.recall_friend_num);
/* 1232 */       _sb_.append(",");
/* 1233 */       _sb_.append(this.last_recall_friend_time);
/* 1234 */       _sb_.append(",");
/* 1235 */       _sb_.append(this.recall_friend_times_today);
/* 1236 */       _sb_.append(",");
/* 1237 */       _sb_.append(this.recall_friend_num_award_serial_no);
/* 1238 */       _sb_.append(",");
/* 1239 */       _sb_.append(this.be_recalled_back_game);
/* 1240 */       _sb_.append(",");
/* 1241 */       _sb_.append(this.rebate_info);
/* 1242 */       _sb_.append(",");
/* 1243 */       _sb_.append(this.cross_recall_friend_times_today);
/* 1244 */       _sb_.append(")");
/* 1245 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RecallFriendBackGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */