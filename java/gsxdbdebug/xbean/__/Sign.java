/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class Sign
/*      */   extends XBean implements xbean.Sign
/*      */ {
/*      */   private int signcount;
/*      */   private long signtime;
/*      */   private int signday;
/*      */   private int fillincount;
/*      */   private int awardedfillincount;
/*      */   private int box_sign_award_state;
/*      */   private int current_precious_cell_num;
/*      */   private int current_precious_box_buff_id;
/*      */   private int lucky_box_sign_box_buff_id;
/*      */   private int lucky_box_gold_precious_cfg_id;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   36 */     this.signcount = 0;
/*   37 */     this.signtime = 0L;
/*   38 */     this.signday = 0;
/*   39 */     this.fillincount = 0;
/*   40 */     this.awardedfillincount = 0;
/*   41 */     this.box_sign_award_state = 0;
/*   42 */     this.current_precious_cell_num = 0;
/*   43 */     this.current_precious_box_buff_id = 0;
/*   44 */     this.lucky_box_sign_box_buff_id = 0;
/*   45 */     this.lucky_box_gold_precious_cfg_id = 0;
/*      */   }
/*      */   
/*      */   Sign(int __, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     this.signcount = 0;
/*   52 */     this.signtime = 0L;
/*   53 */     this.signday = 0;
/*   54 */     this.fillincount = 0;
/*   55 */     this.awardedfillincount = 0;
/*   56 */     this.box_sign_award_state = 0;
/*   57 */     this.current_precious_cell_num = 0;
/*   58 */     this.current_precious_box_buff_id = 0;
/*      */   }
/*      */   
/*      */   public Sign()
/*      */   {
/*   63 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Sign(Sign _o_)
/*      */   {
/*   68 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Sign(xbean.Sign _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   73 */     super(_xp_, _vn_);
/*   74 */     if ((_o1_ instanceof Sign)) { assign((Sign)_o1_);
/*   75 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   76 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   77 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Sign _o_) {
/*   82 */     _o_._xdb_verify_unsafe_();
/*   83 */     this.signcount = _o_.signcount;
/*   84 */     this.signtime = _o_.signtime;
/*   85 */     this.signday = _o_.signday;
/*   86 */     this.fillincount = _o_.fillincount;
/*   87 */     this.awardedfillincount = _o_.awardedfillincount;
/*   88 */     this.box_sign_award_state = _o_.box_sign_award_state;
/*   89 */     this.current_precious_cell_num = _o_.current_precious_cell_num;
/*   90 */     this.current_precious_box_buff_id = _o_.current_precious_box_buff_id;
/*   91 */     this.lucky_box_sign_box_buff_id = _o_.lucky_box_sign_box_buff_id;
/*   92 */     this.lucky_box_gold_precious_cfg_id = _o_.lucky_box_gold_precious_cfg_id;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   97 */     this.signcount = _o_.signcount;
/*   98 */     this.signtime = _o_.signtime;
/*   99 */     this.signday = _o_.signday;
/*  100 */     this.fillincount = _o_.fillincount;
/*  101 */     this.awardedfillincount = _o_.awardedfillincount;
/*  102 */     this.box_sign_award_state = _o_.box_sign_award_state;
/*  103 */     this.current_precious_cell_num = _o_.current_precious_cell_num;
/*  104 */     this.current_precious_box_buff_id = _o_.current_precious_box_buff_id;
/*  105 */     this.lucky_box_sign_box_buff_id = _o_.lucky_box_sign_box_buff_id;
/*  106 */     this.lucky_box_gold_precious_cfg_id = _o_.lucky_box_gold_precious_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     _os_.marshal(this.signcount);
/*  114 */     _os_.marshal(this.signtime);
/*  115 */     _os_.marshal(this.signday);
/*  116 */     _os_.marshal(this.fillincount);
/*  117 */     _os_.marshal(this.awardedfillincount);
/*  118 */     _os_.marshal(this.box_sign_award_state);
/*  119 */     _os_.marshal(this.current_precious_cell_num);
/*  120 */     _os_.marshal(this.current_precious_box_buff_id);
/*  121 */     _os_.marshal(this.lucky_box_sign_box_buff_id);
/*  122 */     _os_.marshal(this.lucky_box_gold_precious_cfg_id);
/*  123 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  129 */     _xdb_verify_unsafe_();
/*  130 */     this.signcount = _os_.unmarshal_int();
/*  131 */     this.signtime = _os_.unmarshal_long();
/*  132 */     this.signday = _os_.unmarshal_int();
/*  133 */     this.fillincount = _os_.unmarshal_int();
/*  134 */     this.awardedfillincount = _os_.unmarshal_int();
/*  135 */     this.box_sign_award_state = _os_.unmarshal_int();
/*  136 */     this.current_precious_cell_num = _os_.unmarshal_int();
/*  137 */     this.current_precious_box_buff_id = _os_.unmarshal_int();
/*  138 */     this.lucky_box_sign_box_buff_id = _os_.unmarshal_int();
/*  139 */     this.lucky_box_gold_precious_cfg_id = _os_.unmarshal_int();
/*  140 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  146 */     _xdb_verify_unsafe_();
/*  147 */     int _size_ = 0;
/*  148 */     _size_ += CodedOutputStream.computeInt32Size(1, this.signcount);
/*  149 */     _size_ += CodedOutputStream.computeInt64Size(2, this.signtime);
/*  150 */     _size_ += CodedOutputStream.computeInt32Size(3, this.signday);
/*  151 */     _size_ += CodedOutputStream.computeInt32Size(4, this.fillincount);
/*  152 */     _size_ += CodedOutputStream.computeInt32Size(5, this.awardedfillincount);
/*  153 */     _size_ += CodedOutputStream.computeInt32Size(6, this.box_sign_award_state);
/*  154 */     _size_ += CodedOutputStream.computeInt32Size(7, this.current_precious_cell_num);
/*  155 */     _size_ += CodedOutputStream.computeInt32Size(8, this.current_precious_box_buff_id);
/*  156 */     _size_ += CodedOutputStream.computeInt32Size(9, this.lucky_box_sign_box_buff_id);
/*  157 */     _size_ += CodedOutputStream.computeInt32Size(10, this.lucky_box_gold_precious_cfg_id);
/*  158 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  167 */       _output_.writeInt32(1, this.signcount);
/*  168 */       _output_.writeInt64(2, this.signtime);
/*  169 */       _output_.writeInt32(3, this.signday);
/*  170 */       _output_.writeInt32(4, this.fillincount);
/*  171 */       _output_.writeInt32(5, this.awardedfillincount);
/*  172 */       _output_.writeInt32(6, this.box_sign_award_state);
/*  173 */       _output_.writeInt32(7, this.current_precious_cell_num);
/*  174 */       _output_.writeInt32(8, this.current_precious_box_buff_id);
/*  175 */       _output_.writeInt32(9, this.lucky_box_sign_box_buff_id);
/*  176 */       _output_.writeInt32(10, this.lucky_box_gold_precious_cfg_id);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  180 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  182 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  188 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  191 */       boolean done = false;
/*  192 */       while (!done)
/*      */       {
/*  194 */         int tag = _input_.readTag();
/*  195 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  199 */           done = true;
/*  200 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  204 */           this.signcount = _input_.readInt32();
/*  205 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  209 */           this.signtime = _input_.readInt64();
/*  210 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  214 */           this.signday = _input_.readInt32();
/*  215 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  219 */           this.fillincount = _input_.readInt32();
/*  220 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  224 */           this.awardedfillincount = _input_.readInt32();
/*  225 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  229 */           this.box_sign_award_state = _input_.readInt32();
/*  230 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  234 */           this.current_precious_cell_num = _input_.readInt32();
/*  235 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  239 */           this.current_precious_box_buff_id = _input_.readInt32();
/*  240 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  244 */           this.lucky_box_sign_box_buff_id = _input_.readInt32();
/*  245 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  249 */           this.lucky_box_gold_precious_cfg_id = _input_.readInt32();
/*  250 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  254 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  256 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  265 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  269 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  271 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Sign copy()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return new Sign(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Sign toData()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Sign toBean()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return new Sign(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Sign toDataIf()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*  298 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Sign toBeanIf()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSigncount()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return this.signcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSigntime()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.signtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSignday()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return this.signday;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFillincount()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return this.fillincount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAwardedfillincount()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return this.awardedfillincount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBox_sign_award_state()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return this.box_sign_award_state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_precious_cell_num()
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     return this.current_precious_cell_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_precious_box_buff_id()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     return this.current_precious_box_buff_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLucky_box_sign_box_buff_id()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     return this.lucky_box_sign_box_buff_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLucky_box_gold_precious_cfg_id()
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     return this.lucky_box_gold_precious_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSigncount(int _v_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     Logs.logIf(new LogKey(this, "signcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  403 */         new LogInt(this, Sign.this.signcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  407 */             Sign.this.signcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  411 */     });
/*  412 */     this.signcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSigntime(long _v_)
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     Logs.logIf(new LogKey(this, "signtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  424 */         new LogLong(this, Sign.this.signtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  428 */             Sign.this.signtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  432 */     });
/*  433 */     this.signtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSignday(int _v_)
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     Logs.logIf(new LogKey(this, "signday")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  445 */         new LogInt(this, Sign.this.signday)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  449 */             Sign.this.signday = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  453 */     });
/*  454 */     this.signday = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFillincount(int _v_)
/*      */   {
/*  461 */     _xdb_verify_unsafe_();
/*  462 */     Logs.logIf(new LogKey(this, "fillincount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  466 */         new LogInt(this, Sign.this.fillincount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  470 */             Sign.this.fillincount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  474 */     });
/*  475 */     this.fillincount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAwardedfillincount(int _v_)
/*      */   {
/*  482 */     _xdb_verify_unsafe_();
/*  483 */     Logs.logIf(new LogKey(this, "awardedfillincount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  487 */         new LogInt(this, Sign.this.awardedfillincount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  491 */             Sign.this.awardedfillincount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  495 */     });
/*  496 */     this.awardedfillincount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBox_sign_award_state(int _v_)
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     Logs.logIf(new LogKey(this, "box_sign_award_state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  508 */         new LogInt(this, Sign.this.box_sign_award_state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  512 */             Sign.this.box_sign_award_state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  516 */     });
/*  517 */     this.box_sign_award_state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_precious_cell_num(int _v_)
/*      */   {
/*  524 */     _xdb_verify_unsafe_();
/*  525 */     Logs.logIf(new LogKey(this, "current_precious_cell_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  529 */         new LogInt(this, Sign.this.current_precious_cell_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  533 */             Sign.this.current_precious_cell_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  537 */     });
/*  538 */     this.current_precious_cell_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_precious_box_buff_id(int _v_)
/*      */   {
/*  545 */     _xdb_verify_unsafe_();
/*  546 */     Logs.logIf(new LogKey(this, "current_precious_box_buff_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  550 */         new LogInt(this, Sign.this.current_precious_box_buff_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  554 */             Sign.this.current_precious_box_buff_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  558 */     });
/*  559 */     this.current_precious_box_buff_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLucky_box_sign_box_buff_id(int _v_)
/*      */   {
/*  566 */     _xdb_verify_unsafe_();
/*  567 */     Logs.logIf(new LogKey(this, "lucky_box_sign_box_buff_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  571 */         new LogInt(this, Sign.this.lucky_box_sign_box_buff_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  575 */             Sign.this.lucky_box_sign_box_buff_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  579 */     });
/*  580 */     this.lucky_box_sign_box_buff_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLucky_box_gold_precious_cfg_id(int _v_)
/*      */   {
/*  587 */     _xdb_verify_unsafe_();
/*  588 */     Logs.logIf(new LogKey(this, "lucky_box_gold_precious_cfg_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  592 */         new LogInt(this, Sign.this.lucky_box_gold_precious_cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  596 */             Sign.this.lucky_box_gold_precious_cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  600 */     });
/*  601 */     this.lucky_box_gold_precious_cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  607 */     _xdb_verify_unsafe_();
/*  608 */     Sign _o_ = null;
/*  609 */     if ((_o1_ instanceof Sign)) { _o_ = (Sign)_o1_;
/*  610 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  611 */       return false;
/*  612 */     if (this.signcount != _o_.signcount) return false;
/*  613 */     if (this.signtime != _o_.signtime) return false;
/*  614 */     if (this.signday != _o_.signday) return false;
/*  615 */     if (this.fillincount != _o_.fillincount) return false;
/*  616 */     if (this.awardedfillincount != _o_.awardedfillincount) return false;
/*  617 */     if (this.box_sign_award_state != _o_.box_sign_award_state) return false;
/*  618 */     if (this.current_precious_cell_num != _o_.current_precious_cell_num) return false;
/*  619 */     if (this.current_precious_box_buff_id != _o_.current_precious_box_buff_id) return false;
/*  620 */     if (this.lucky_box_sign_box_buff_id != _o_.lucky_box_sign_box_buff_id) return false;
/*  621 */     if (this.lucky_box_gold_precious_cfg_id != _o_.lucky_box_gold_precious_cfg_id) return false;
/*  622 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  628 */     _xdb_verify_unsafe_();
/*  629 */     int _h_ = 0;
/*  630 */     _h_ += this.signcount;
/*  631 */     _h_ = (int)(_h_ + this.signtime);
/*  632 */     _h_ += this.signday;
/*  633 */     _h_ += this.fillincount;
/*  634 */     _h_ += this.awardedfillincount;
/*  635 */     _h_ += this.box_sign_award_state;
/*  636 */     _h_ += this.current_precious_cell_num;
/*  637 */     _h_ += this.current_precious_box_buff_id;
/*  638 */     _h_ += this.lucky_box_sign_box_buff_id;
/*  639 */     _h_ += this.lucky_box_gold_precious_cfg_id;
/*  640 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  646 */     _xdb_verify_unsafe_();
/*  647 */     StringBuilder _sb_ = new StringBuilder();
/*  648 */     _sb_.append("(");
/*  649 */     _sb_.append(this.signcount);
/*  650 */     _sb_.append(",");
/*  651 */     _sb_.append(this.signtime);
/*  652 */     _sb_.append(",");
/*  653 */     _sb_.append(this.signday);
/*  654 */     _sb_.append(",");
/*  655 */     _sb_.append(this.fillincount);
/*  656 */     _sb_.append(",");
/*  657 */     _sb_.append(this.awardedfillincount);
/*  658 */     _sb_.append(",");
/*  659 */     _sb_.append(this.box_sign_award_state);
/*  660 */     _sb_.append(",");
/*  661 */     _sb_.append(this.current_precious_cell_num);
/*  662 */     _sb_.append(",");
/*  663 */     _sb_.append(this.current_precious_box_buff_id);
/*  664 */     _sb_.append(",");
/*  665 */     _sb_.append(this.lucky_box_sign_box_buff_id);
/*  666 */     _sb_.append(",");
/*  667 */     _sb_.append(this.lucky_box_gold_precious_cfg_id);
/*  668 */     _sb_.append(")");
/*  669 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/*  675 */     ListenableBean lb = new ListenableBean();
/*  676 */     lb.add(new ListenableChanged().setVarName("signcount"));
/*  677 */     lb.add(new ListenableChanged().setVarName("signtime"));
/*  678 */     lb.add(new ListenableChanged().setVarName("signday"));
/*  679 */     lb.add(new ListenableChanged().setVarName("fillincount"));
/*  680 */     lb.add(new ListenableChanged().setVarName("awardedfillincount"));
/*  681 */     lb.add(new ListenableChanged().setVarName("box_sign_award_state"));
/*  682 */     lb.add(new ListenableChanged().setVarName("current_precious_cell_num"));
/*  683 */     lb.add(new ListenableChanged().setVarName("current_precious_box_buff_id"));
/*  684 */     lb.add(new ListenableChanged().setVarName("lucky_box_sign_box_buff_id"));
/*  685 */     lb.add(new ListenableChanged().setVarName("lucky_box_gold_precious_cfg_id"));
/*  686 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Sign {
/*      */     private Const() {}
/*      */     
/*      */     Sign nThis() {
/*  693 */       return Sign.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  699 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sign copy()
/*      */     {
/*  705 */       return Sign.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sign toData()
/*      */     {
/*  711 */       return Sign.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Sign toBean()
/*      */     {
/*  716 */       return Sign.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sign toDataIf()
/*      */     {
/*  722 */       return Sign.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Sign toBeanIf()
/*      */     {
/*  727 */       return Sign.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSigncount()
/*      */     {
/*  734 */       Sign.this._xdb_verify_unsafe_();
/*  735 */       return Sign.this.signcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSigntime()
/*      */     {
/*  742 */       Sign.this._xdb_verify_unsafe_();
/*  743 */       return Sign.this.signtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSignday()
/*      */     {
/*  750 */       Sign.this._xdb_verify_unsafe_();
/*  751 */       return Sign.this.signday;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFillincount()
/*      */     {
/*  758 */       Sign.this._xdb_verify_unsafe_();
/*  759 */       return Sign.this.fillincount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAwardedfillincount()
/*      */     {
/*  766 */       Sign.this._xdb_verify_unsafe_();
/*  767 */       return Sign.this.awardedfillincount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBox_sign_award_state()
/*      */     {
/*  774 */       Sign.this._xdb_verify_unsafe_();
/*  775 */       return Sign.this.box_sign_award_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_precious_cell_num()
/*      */     {
/*  782 */       Sign.this._xdb_verify_unsafe_();
/*  783 */       return Sign.this.current_precious_cell_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_precious_box_buff_id()
/*      */     {
/*  790 */       Sign.this._xdb_verify_unsafe_();
/*  791 */       return Sign.this.current_precious_box_buff_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLucky_box_sign_box_buff_id()
/*      */     {
/*  798 */       Sign.this._xdb_verify_unsafe_();
/*  799 */       return Sign.this.lucky_box_sign_box_buff_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLucky_box_gold_precious_cfg_id()
/*      */     {
/*  806 */       Sign.this._xdb_verify_unsafe_();
/*  807 */       return Sign.this.lucky_box_gold_precious_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSigncount(int _v_)
/*      */     {
/*  814 */       Sign.this._xdb_verify_unsafe_();
/*  815 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSigntime(long _v_)
/*      */     {
/*  822 */       Sign.this._xdb_verify_unsafe_();
/*  823 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignday(int _v_)
/*      */     {
/*  830 */       Sign.this._xdb_verify_unsafe_();
/*  831 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFillincount(int _v_)
/*      */     {
/*  838 */       Sign.this._xdb_verify_unsafe_();
/*  839 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAwardedfillincount(int _v_)
/*      */     {
/*  846 */       Sign.this._xdb_verify_unsafe_();
/*  847 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBox_sign_award_state(int _v_)
/*      */     {
/*  854 */       Sign.this._xdb_verify_unsafe_();
/*  855 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_precious_cell_num(int _v_)
/*      */     {
/*  862 */       Sign.this._xdb_verify_unsafe_();
/*  863 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_precious_box_buff_id(int _v_)
/*      */     {
/*  870 */       Sign.this._xdb_verify_unsafe_();
/*  871 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLucky_box_sign_box_buff_id(int _v_)
/*      */     {
/*  878 */       Sign.this._xdb_verify_unsafe_();
/*  879 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLucky_box_gold_precious_cfg_id(int _v_)
/*      */     {
/*  886 */       Sign.this._xdb_verify_unsafe_();
/*  887 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  893 */       Sign.this._xdb_verify_unsafe_();
/*  894 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  900 */       Sign.this._xdb_verify_unsafe_();
/*  901 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  907 */       return Sign.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  913 */       return Sign.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  919 */       Sign.this._xdb_verify_unsafe_();
/*  920 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  926 */       return Sign.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  932 */       return Sign.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  938 */       Sign.this._xdb_verify_unsafe_();
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  945 */       return Sign.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  951 */       return Sign.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  957 */       return Sign.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  963 */       return Sign.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  969 */       return Sign.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  975 */       return Sign.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  981 */       return Sign.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Sign
/*      */   {
/*      */     private int signcount;
/*      */     
/*      */     private long signtime;
/*      */     
/*      */     private int signday;
/*      */     
/*      */     private int fillincount;
/*      */     
/*      */     private int awardedfillincount;
/*      */     
/*      */     private int box_sign_award_state;
/*      */     
/*      */     private int current_precious_cell_num;
/*      */     
/*      */     private int current_precious_box_buff_id;
/*      */     
/*      */     private int lucky_box_sign_box_buff_id;
/*      */     
/*      */     private int lucky_box_gold_precious_cfg_id;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1011 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1016 */       this.signcount = 0;
/* 1017 */       this.signtime = 0L;
/* 1018 */       this.signday = 0;
/* 1019 */       this.fillincount = 0;
/* 1020 */       this.awardedfillincount = 0;
/* 1021 */       this.box_sign_award_state = 0;
/* 1022 */       this.current_precious_cell_num = 0;
/* 1023 */       this.current_precious_box_buff_id = 0;
/*      */     }
/*      */     
/*      */     Data(xbean.Sign _o1_)
/*      */     {
/* 1028 */       if ((_o1_ instanceof Sign)) { assign((Sign)_o1_);
/* 1029 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1030 */       } else if ((_o1_ instanceof Sign.Const)) assign(((Sign.Const)_o1_).nThis()); else {
/* 1031 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Sign _o_) {
/* 1036 */       this.signcount = _o_.signcount;
/* 1037 */       this.signtime = _o_.signtime;
/* 1038 */       this.signday = _o_.signday;
/* 1039 */       this.fillincount = _o_.fillincount;
/* 1040 */       this.awardedfillincount = _o_.awardedfillincount;
/* 1041 */       this.box_sign_award_state = _o_.box_sign_award_state;
/* 1042 */       this.current_precious_cell_num = _o_.current_precious_cell_num;
/* 1043 */       this.current_precious_box_buff_id = _o_.current_precious_box_buff_id;
/* 1044 */       this.lucky_box_sign_box_buff_id = _o_.lucky_box_sign_box_buff_id;
/* 1045 */       this.lucky_box_gold_precious_cfg_id = _o_.lucky_box_gold_precious_cfg_id;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1050 */       this.signcount = _o_.signcount;
/* 1051 */       this.signtime = _o_.signtime;
/* 1052 */       this.signday = _o_.signday;
/* 1053 */       this.fillincount = _o_.fillincount;
/* 1054 */       this.awardedfillincount = _o_.awardedfillincount;
/* 1055 */       this.box_sign_award_state = _o_.box_sign_award_state;
/* 1056 */       this.current_precious_cell_num = _o_.current_precious_cell_num;
/* 1057 */       this.current_precious_box_buff_id = _o_.current_precious_box_buff_id;
/* 1058 */       this.lucky_box_sign_box_buff_id = _o_.lucky_box_sign_box_buff_id;
/* 1059 */       this.lucky_box_gold_precious_cfg_id = _o_.lucky_box_gold_precious_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1065 */       _os_.marshal(this.signcount);
/* 1066 */       _os_.marshal(this.signtime);
/* 1067 */       _os_.marshal(this.signday);
/* 1068 */       _os_.marshal(this.fillincount);
/* 1069 */       _os_.marshal(this.awardedfillincount);
/* 1070 */       _os_.marshal(this.box_sign_award_state);
/* 1071 */       _os_.marshal(this.current_precious_cell_num);
/* 1072 */       _os_.marshal(this.current_precious_box_buff_id);
/* 1073 */       _os_.marshal(this.lucky_box_sign_box_buff_id);
/* 1074 */       _os_.marshal(this.lucky_box_gold_precious_cfg_id);
/* 1075 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1081 */       this.signcount = _os_.unmarshal_int();
/* 1082 */       this.signtime = _os_.unmarshal_long();
/* 1083 */       this.signday = _os_.unmarshal_int();
/* 1084 */       this.fillincount = _os_.unmarshal_int();
/* 1085 */       this.awardedfillincount = _os_.unmarshal_int();
/* 1086 */       this.box_sign_award_state = _os_.unmarshal_int();
/* 1087 */       this.current_precious_cell_num = _os_.unmarshal_int();
/* 1088 */       this.current_precious_box_buff_id = _os_.unmarshal_int();
/* 1089 */       this.lucky_box_sign_box_buff_id = _os_.unmarshal_int();
/* 1090 */       this.lucky_box_gold_precious_cfg_id = _os_.unmarshal_int();
/* 1091 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1097 */       int _size_ = 0;
/* 1098 */       _size_ += CodedOutputStream.computeInt32Size(1, this.signcount);
/* 1099 */       _size_ += CodedOutputStream.computeInt64Size(2, this.signtime);
/* 1100 */       _size_ += CodedOutputStream.computeInt32Size(3, this.signday);
/* 1101 */       _size_ += CodedOutputStream.computeInt32Size(4, this.fillincount);
/* 1102 */       _size_ += CodedOutputStream.computeInt32Size(5, this.awardedfillincount);
/* 1103 */       _size_ += CodedOutputStream.computeInt32Size(6, this.box_sign_award_state);
/* 1104 */       _size_ += CodedOutputStream.computeInt32Size(7, this.current_precious_cell_num);
/* 1105 */       _size_ += CodedOutputStream.computeInt32Size(8, this.current_precious_box_buff_id);
/* 1106 */       _size_ += CodedOutputStream.computeInt32Size(9, this.lucky_box_sign_box_buff_id);
/* 1107 */       _size_ += CodedOutputStream.computeInt32Size(10, this.lucky_box_gold_precious_cfg_id);
/* 1108 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1116 */         _output_.writeInt32(1, this.signcount);
/* 1117 */         _output_.writeInt64(2, this.signtime);
/* 1118 */         _output_.writeInt32(3, this.signday);
/* 1119 */         _output_.writeInt32(4, this.fillincount);
/* 1120 */         _output_.writeInt32(5, this.awardedfillincount);
/* 1121 */         _output_.writeInt32(6, this.box_sign_award_state);
/* 1122 */         _output_.writeInt32(7, this.current_precious_cell_num);
/* 1123 */         _output_.writeInt32(8, this.current_precious_box_buff_id);
/* 1124 */         _output_.writeInt32(9, this.lucky_box_sign_box_buff_id);
/* 1125 */         _output_.writeInt32(10, this.lucky_box_gold_precious_cfg_id);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1129 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1131 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1139 */         boolean done = false;
/* 1140 */         while (!done)
/*      */         {
/* 1142 */           int tag = _input_.readTag();
/* 1143 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1147 */             done = true;
/* 1148 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1152 */             this.signcount = _input_.readInt32();
/* 1153 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1157 */             this.signtime = _input_.readInt64();
/* 1158 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1162 */             this.signday = _input_.readInt32();
/* 1163 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1167 */             this.fillincount = _input_.readInt32();
/* 1168 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1172 */             this.awardedfillincount = _input_.readInt32();
/* 1173 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1177 */             this.box_sign_award_state = _input_.readInt32();
/* 1178 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1182 */             this.current_precious_cell_num = _input_.readInt32();
/* 1183 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1187 */             this.current_precious_box_buff_id = _input_.readInt32();
/* 1188 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1192 */             this.lucky_box_sign_box_buff_id = _input_.readInt32();
/* 1193 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1197 */             this.lucky_box_gold_precious_cfg_id = _input_.readInt32();
/* 1198 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1202 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1204 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1213 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1217 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1219 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sign copy()
/*      */     {
/* 1225 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sign toData()
/*      */     {
/* 1231 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Sign toBean()
/*      */     {
/* 1236 */       return new Sign(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sign toDataIf()
/*      */     {
/* 1242 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Sign toBeanIf()
/*      */     {
/* 1247 */       return new Sign(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1253 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1257 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1261 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1265 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1269 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1273 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1277 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSigncount()
/*      */     {
/* 1284 */       return this.signcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSigntime()
/*      */     {
/* 1291 */       return this.signtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSignday()
/*      */     {
/* 1298 */       return this.signday;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFillincount()
/*      */     {
/* 1305 */       return this.fillincount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAwardedfillincount()
/*      */     {
/* 1312 */       return this.awardedfillincount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBox_sign_award_state()
/*      */     {
/* 1319 */       return this.box_sign_award_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_precious_cell_num()
/*      */     {
/* 1326 */       return this.current_precious_cell_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_precious_box_buff_id()
/*      */     {
/* 1333 */       return this.current_precious_box_buff_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLucky_box_sign_box_buff_id()
/*      */     {
/* 1340 */       return this.lucky_box_sign_box_buff_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLucky_box_gold_precious_cfg_id()
/*      */     {
/* 1347 */       return this.lucky_box_gold_precious_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSigncount(int _v_)
/*      */     {
/* 1354 */       this.signcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSigntime(long _v_)
/*      */     {
/* 1361 */       this.signtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignday(int _v_)
/*      */     {
/* 1368 */       this.signday = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFillincount(int _v_)
/*      */     {
/* 1375 */       this.fillincount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAwardedfillincount(int _v_)
/*      */     {
/* 1382 */       this.awardedfillincount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBox_sign_award_state(int _v_)
/*      */     {
/* 1389 */       this.box_sign_award_state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_precious_cell_num(int _v_)
/*      */     {
/* 1396 */       this.current_precious_cell_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_precious_box_buff_id(int _v_)
/*      */     {
/* 1403 */       this.current_precious_box_buff_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLucky_box_sign_box_buff_id(int _v_)
/*      */     {
/* 1410 */       this.lucky_box_sign_box_buff_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLucky_box_gold_precious_cfg_id(int _v_)
/*      */     {
/* 1417 */       this.lucky_box_gold_precious_cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1423 */       if (!(_o1_ instanceof Data)) return false;
/* 1424 */       Data _o_ = (Data)_o1_;
/* 1425 */       if (this.signcount != _o_.signcount) return false;
/* 1426 */       if (this.signtime != _o_.signtime) return false;
/* 1427 */       if (this.signday != _o_.signday) return false;
/* 1428 */       if (this.fillincount != _o_.fillincount) return false;
/* 1429 */       if (this.awardedfillincount != _o_.awardedfillincount) return false;
/* 1430 */       if (this.box_sign_award_state != _o_.box_sign_award_state) return false;
/* 1431 */       if (this.current_precious_cell_num != _o_.current_precious_cell_num) return false;
/* 1432 */       if (this.current_precious_box_buff_id != _o_.current_precious_box_buff_id) return false;
/* 1433 */       if (this.lucky_box_sign_box_buff_id != _o_.lucky_box_sign_box_buff_id) return false;
/* 1434 */       if (this.lucky_box_gold_precious_cfg_id != _o_.lucky_box_gold_precious_cfg_id) return false;
/* 1435 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1441 */       int _h_ = 0;
/* 1442 */       _h_ += this.signcount;
/* 1443 */       _h_ = (int)(_h_ + this.signtime);
/* 1444 */       _h_ += this.signday;
/* 1445 */       _h_ += this.fillincount;
/* 1446 */       _h_ += this.awardedfillincount;
/* 1447 */       _h_ += this.box_sign_award_state;
/* 1448 */       _h_ += this.current_precious_cell_num;
/* 1449 */       _h_ += this.current_precious_box_buff_id;
/* 1450 */       _h_ += this.lucky_box_sign_box_buff_id;
/* 1451 */       _h_ += this.lucky_box_gold_precious_cfg_id;
/* 1452 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1458 */       StringBuilder _sb_ = new StringBuilder();
/* 1459 */       _sb_.append("(");
/* 1460 */       _sb_.append(this.signcount);
/* 1461 */       _sb_.append(",");
/* 1462 */       _sb_.append(this.signtime);
/* 1463 */       _sb_.append(",");
/* 1464 */       _sb_.append(this.signday);
/* 1465 */       _sb_.append(",");
/* 1466 */       _sb_.append(this.fillincount);
/* 1467 */       _sb_.append(",");
/* 1468 */       _sb_.append(this.awardedfillincount);
/* 1469 */       _sb_.append(",");
/* 1470 */       _sb_.append(this.box_sign_award_state);
/* 1471 */       _sb_.append(",");
/* 1472 */       _sb_.append(this.current_precious_cell_num);
/* 1473 */       _sb_.append(",");
/* 1474 */       _sb_.append(this.current_precious_box_buff_id);
/* 1475 */       _sb_.append(",");
/* 1476 */       _sb_.append(this.lucky_box_sign_box_buff_id);
/* 1477 */       _sb_.append(",");
/* 1478 */       _sb_.append(this.lucky_box_gold_precious_cfg_id);
/* 1479 */       _sb_.append(")");
/* 1480 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Sign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */