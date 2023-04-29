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
/*      */ public final class RoamCrossCompeteRole extends XBean implements xbean.RoamCrossCompeteRole
/*      */ {
/*      */   private long factionid;
/*      */   private int duty;
/*      */   private int action_point;
/*      */   private int win_times;
/*      */   private int lose_times;
/*      */   private int win_streak;
/*      */   private int win_streak_awards;
/*      */   private int final_award;
/*      */   private int escape_times;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.factionid = -1L;
/*   35 */     this.duty = -1;
/*   36 */     this.action_point = 0;
/*   37 */     this.win_times = 0;
/*   38 */     this.lose_times = 0;
/*   39 */     this.win_streak = 0;
/*   40 */     this.win_streak_awards = 0;
/*   41 */     this.final_award = 0;
/*   42 */     this.escape_times = 0;
/*      */   }
/*      */   
/*      */   RoamCrossCompeteRole(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.factionid = -1L;
/*   49 */     this.duty = -1;
/*   50 */     this.action_point = 0;
/*   51 */     this.win_times = 0;
/*   52 */     this.lose_times = 0;
/*   53 */     this.win_streak = 0;
/*   54 */     this.win_streak_awards = 0;
/*   55 */     this.final_award = 0;
/*   56 */     this.escape_times = 0;
/*      */   }
/*      */   
/*      */   public RoamCrossCompeteRole()
/*      */   {
/*   61 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoamCrossCompeteRole(RoamCrossCompeteRole _o_)
/*      */   {
/*   66 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoamCrossCompeteRole(xbean.RoamCrossCompeteRole _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   71 */     super(_xp_, _vn_);
/*   72 */     if ((_o1_ instanceof RoamCrossCompeteRole)) { assign((RoamCrossCompeteRole)_o1_);
/*   73 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   74 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   75 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoamCrossCompeteRole _o_) {
/*   80 */     _o_._xdb_verify_unsafe_();
/*   81 */     this.factionid = _o_.factionid;
/*   82 */     this.duty = _o_.duty;
/*   83 */     this.action_point = _o_.action_point;
/*   84 */     this.win_times = _o_.win_times;
/*   85 */     this.lose_times = _o_.lose_times;
/*   86 */     this.win_streak = _o_.win_streak;
/*   87 */     this.win_streak_awards = _o_.win_streak_awards;
/*   88 */     this.final_award = _o_.final_award;
/*   89 */     this.escape_times = _o_.escape_times;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   94 */     this.factionid = _o_.factionid;
/*   95 */     this.duty = _o_.duty;
/*   96 */     this.action_point = _o_.action_point;
/*   97 */     this.win_times = _o_.win_times;
/*   98 */     this.lose_times = _o_.lose_times;
/*   99 */     this.win_streak = _o_.win_streak;
/*  100 */     this.win_streak_awards = _o_.win_streak_awards;
/*  101 */     this.final_award = _o_.final_award;
/*  102 */     this.escape_times = _o_.escape_times;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  108 */     _xdb_verify_unsafe_();
/*  109 */     _os_.marshal(this.factionid);
/*  110 */     _os_.marshal(this.duty);
/*  111 */     _os_.marshal(this.action_point);
/*  112 */     _os_.marshal(this.win_times);
/*  113 */     _os_.marshal(this.lose_times);
/*  114 */     _os_.marshal(this.win_streak);
/*  115 */     _os_.marshal(this.win_streak_awards);
/*  116 */     _os_.marshal(this.final_award);
/*  117 */     _os_.marshal(this.escape_times);
/*  118 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     this.factionid = _os_.unmarshal_long();
/*  126 */     this.duty = _os_.unmarshal_int();
/*  127 */     this.action_point = _os_.unmarshal_int();
/*  128 */     this.win_times = _os_.unmarshal_int();
/*  129 */     this.lose_times = _os_.unmarshal_int();
/*  130 */     this.win_streak = _os_.unmarshal_int();
/*  131 */     this.win_streak_awards = _os_.unmarshal_int();
/*  132 */     this.final_award = _os_.unmarshal_int();
/*  133 */     this.escape_times = _os_.unmarshal_int();
/*  134 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*  141 */     int _size_ = 0;
/*  142 */     _size_ += CodedOutputStream.computeInt64Size(1, this.factionid);
/*  143 */     _size_ += CodedOutputStream.computeInt32Size(2, this.duty);
/*  144 */     _size_ += CodedOutputStream.computeInt32Size(3, this.action_point);
/*  145 */     _size_ += CodedOutputStream.computeInt32Size(4, this.win_times);
/*  146 */     _size_ += CodedOutputStream.computeInt32Size(5, this.lose_times);
/*  147 */     _size_ += CodedOutputStream.computeInt32Size(6, this.win_streak);
/*  148 */     _size_ += CodedOutputStream.computeInt32Size(7, this.win_streak_awards);
/*  149 */     _size_ += CodedOutputStream.computeInt32Size(8, this.final_award);
/*  150 */     _size_ += CodedOutputStream.computeInt32Size(9, this.escape_times);
/*  151 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  157 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  160 */       _output_.writeInt64(1, this.factionid);
/*  161 */       _output_.writeInt32(2, this.duty);
/*  162 */       _output_.writeInt32(3, this.action_point);
/*  163 */       _output_.writeInt32(4, this.win_times);
/*  164 */       _output_.writeInt32(5, this.lose_times);
/*  165 */       _output_.writeInt32(6, this.win_streak);
/*  166 */       _output_.writeInt32(7, this.win_streak_awards);
/*  167 */       _output_.writeInt32(8, this.final_award);
/*  168 */       _output_.writeInt32(9, this.escape_times);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  172 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  174 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  180 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  183 */       boolean done = false;
/*  184 */       while (!done)
/*      */       {
/*  186 */         int tag = _input_.readTag();
/*  187 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  191 */           done = true;
/*  192 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  196 */           this.factionid = _input_.readInt64();
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  201 */           this.duty = _input_.readInt32();
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  206 */           this.action_point = _input_.readInt32();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  211 */           this.win_times = _input_.readInt32();
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  216 */           this.lose_times = _input_.readInt32();
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  221 */           this.win_streak = _input_.readInt32();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  226 */           this.win_streak_awards = _input_.readInt32();
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  231 */           this.final_award = _input_.readInt32();
/*  232 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  236 */           this.escape_times = _input_.readInt32();
/*  237 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  241 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  243 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  252 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  256 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  258 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoamCrossCompeteRole copy()
/*      */   {
/*  264 */     _xdb_verify_unsafe_();
/*  265 */     return new RoamCrossCompeteRole(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoamCrossCompeteRole toData()
/*      */   {
/*  271 */     _xdb_verify_unsafe_();
/*  272 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoamCrossCompeteRole toBean()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return new RoamCrossCompeteRole(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoamCrossCompeteRole toDataIf()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoamCrossCompeteRole toBeanIf()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*  298 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getFactionid()
/*      */   {
/*  305 */     _xdb_verify_unsafe_();
/*  306 */     return this.factionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDuty()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return this.duty;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAction_point()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return this.action_point;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWin_times()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return this.win_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLose_times()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return this.lose_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWin_streak()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     return this.win_streak;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWin_streak_awards()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     return this.win_streak_awards;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFinal_award()
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*  362 */     return this.final_award;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getEscape_times()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return this.escape_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFactionid(long _v_)
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     Logs.logIf(new LogKey(this, "factionid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  382 */         new LogLong(this, RoamCrossCompeteRole.this.factionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  386 */             RoamCrossCompeteRole.this.factionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  390 */     });
/*  391 */     this.factionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDuty(int _v_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     Logs.logIf(new LogKey(this, "duty")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  403 */         new LogInt(this, RoamCrossCompeteRole.this.duty)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  407 */             RoamCrossCompeteRole.this.duty = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  411 */     });
/*  412 */     this.duty = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAction_point(int _v_)
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     Logs.logIf(new LogKey(this, "action_point")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  424 */         new LogInt(this, RoamCrossCompeteRole.this.action_point)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  428 */             RoamCrossCompeteRole.this.action_point = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  432 */     });
/*  433 */     this.action_point = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWin_times(int _v_)
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     Logs.logIf(new LogKey(this, "win_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  445 */         new LogInt(this, RoamCrossCompeteRole.this.win_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  449 */             RoamCrossCompeteRole.this.win_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  453 */     });
/*  454 */     this.win_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLose_times(int _v_)
/*      */   {
/*  461 */     _xdb_verify_unsafe_();
/*  462 */     Logs.logIf(new LogKey(this, "lose_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  466 */         new LogInt(this, RoamCrossCompeteRole.this.lose_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  470 */             RoamCrossCompeteRole.this.lose_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  474 */     });
/*  475 */     this.lose_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWin_streak(int _v_)
/*      */   {
/*  482 */     _xdb_verify_unsafe_();
/*  483 */     Logs.logIf(new LogKey(this, "win_streak")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  487 */         new LogInt(this, RoamCrossCompeteRole.this.win_streak)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  491 */             RoamCrossCompeteRole.this.win_streak = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  495 */     });
/*  496 */     this.win_streak = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWin_streak_awards(int _v_)
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     Logs.logIf(new LogKey(this, "win_streak_awards")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  508 */         new LogInt(this, RoamCrossCompeteRole.this.win_streak_awards)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  512 */             RoamCrossCompeteRole.this.win_streak_awards = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  516 */     });
/*  517 */     this.win_streak_awards = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFinal_award(int _v_)
/*      */   {
/*  524 */     _xdb_verify_unsafe_();
/*  525 */     Logs.logIf(new LogKey(this, "final_award")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  529 */         new LogInt(this, RoamCrossCompeteRole.this.final_award)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  533 */             RoamCrossCompeteRole.this.final_award = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  537 */     });
/*  538 */     this.final_award = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEscape_times(int _v_)
/*      */   {
/*  545 */     _xdb_verify_unsafe_();
/*  546 */     Logs.logIf(new LogKey(this, "escape_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  550 */         new LogInt(this, RoamCrossCompeteRole.this.escape_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  554 */             RoamCrossCompeteRole.this.escape_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  558 */     });
/*  559 */     this.escape_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  565 */     _xdb_verify_unsafe_();
/*  566 */     RoamCrossCompeteRole _o_ = null;
/*  567 */     if ((_o1_ instanceof RoamCrossCompeteRole)) { _o_ = (RoamCrossCompeteRole)_o1_;
/*  568 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  569 */       return false;
/*  570 */     if (this.factionid != _o_.factionid) return false;
/*  571 */     if (this.duty != _o_.duty) return false;
/*  572 */     if (this.action_point != _o_.action_point) return false;
/*  573 */     if (this.win_times != _o_.win_times) return false;
/*  574 */     if (this.lose_times != _o_.lose_times) return false;
/*  575 */     if (this.win_streak != _o_.win_streak) return false;
/*  576 */     if (this.win_streak_awards != _o_.win_streak_awards) return false;
/*  577 */     if (this.final_award != _o_.final_award) return false;
/*  578 */     if (this.escape_times != _o_.escape_times) return false;
/*  579 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  585 */     _xdb_verify_unsafe_();
/*  586 */     int _h_ = 0;
/*  587 */     _h_ = (int)(_h_ + this.factionid);
/*  588 */     _h_ += this.duty;
/*  589 */     _h_ += this.action_point;
/*  590 */     _h_ += this.win_times;
/*  591 */     _h_ += this.lose_times;
/*  592 */     _h_ += this.win_streak;
/*  593 */     _h_ += this.win_streak_awards;
/*  594 */     _h_ += this.final_award;
/*  595 */     _h_ += this.escape_times;
/*  596 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  602 */     _xdb_verify_unsafe_();
/*  603 */     StringBuilder _sb_ = new StringBuilder();
/*  604 */     _sb_.append("(");
/*  605 */     _sb_.append(this.factionid);
/*  606 */     _sb_.append(",");
/*  607 */     _sb_.append(this.duty);
/*  608 */     _sb_.append(",");
/*  609 */     _sb_.append(this.action_point);
/*  610 */     _sb_.append(",");
/*  611 */     _sb_.append(this.win_times);
/*  612 */     _sb_.append(",");
/*  613 */     _sb_.append(this.lose_times);
/*  614 */     _sb_.append(",");
/*  615 */     _sb_.append(this.win_streak);
/*  616 */     _sb_.append(",");
/*  617 */     _sb_.append(this.win_streak_awards);
/*  618 */     _sb_.append(",");
/*  619 */     _sb_.append(this.final_award);
/*  620 */     _sb_.append(",");
/*  621 */     _sb_.append(this.escape_times);
/*  622 */     _sb_.append(")");
/*  623 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/*  629 */     ListenableBean lb = new ListenableBean();
/*  630 */     lb.add(new ListenableChanged().setVarName("factionid"));
/*  631 */     lb.add(new ListenableChanged().setVarName("duty"));
/*  632 */     lb.add(new ListenableChanged().setVarName("action_point"));
/*  633 */     lb.add(new ListenableChanged().setVarName("win_times"));
/*  634 */     lb.add(new ListenableChanged().setVarName("lose_times"));
/*  635 */     lb.add(new ListenableChanged().setVarName("win_streak"));
/*  636 */     lb.add(new ListenableChanged().setVarName("win_streak_awards"));
/*  637 */     lb.add(new ListenableChanged().setVarName("final_award"));
/*  638 */     lb.add(new ListenableChanged().setVarName("escape_times"));
/*  639 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoamCrossCompeteRole {
/*      */     private Const() {}
/*      */     
/*      */     RoamCrossCompeteRole nThis() {
/*  646 */       return RoamCrossCompeteRole.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  652 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteRole copy()
/*      */     {
/*  658 */       return RoamCrossCompeteRole.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteRole toData()
/*      */     {
/*  664 */       return RoamCrossCompeteRole.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoamCrossCompeteRole toBean()
/*      */     {
/*  669 */       return RoamCrossCompeteRole.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteRole toDataIf()
/*      */     {
/*  675 */       return RoamCrossCompeteRole.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoamCrossCompeteRole toBeanIf()
/*      */     {
/*  680 */       return RoamCrossCompeteRole.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFactionid()
/*      */     {
/*  687 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  688 */       return RoamCrossCompeteRole.this.factionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDuty()
/*      */     {
/*  695 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  696 */       return RoamCrossCompeteRole.this.duty;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAction_point()
/*      */     {
/*  703 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  704 */       return RoamCrossCompeteRole.this.action_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/*  711 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  712 */       return RoamCrossCompeteRole.this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_times()
/*      */     {
/*  719 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  720 */       return RoamCrossCompeteRole.this.lose_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_streak()
/*      */     {
/*  727 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  728 */       return RoamCrossCompeteRole.this.win_streak;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_streak_awards()
/*      */     {
/*  735 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  736 */       return RoamCrossCompeteRole.this.win_streak_awards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFinal_award()
/*      */     {
/*  743 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  744 */       return RoamCrossCompeteRole.this.final_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEscape_times()
/*      */     {
/*  751 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  752 */       return RoamCrossCompeteRole.this.escape_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFactionid(long _v_)
/*      */     {
/*  759 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  760 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDuty(int _v_)
/*      */     {
/*  767 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  768 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAction_point(int _v_)
/*      */     {
/*  775 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  776 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/*  783 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  784 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_times(int _v_)
/*      */     {
/*  791 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  792 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_streak(int _v_)
/*      */     {
/*  799 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  800 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_streak_awards(int _v_)
/*      */     {
/*  807 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  808 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinal_award(int _v_)
/*      */     {
/*  815 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  816 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEscape_times(int _v_)
/*      */     {
/*  823 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  824 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  830 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  831 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  837 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  838 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  844 */       return RoamCrossCompeteRole.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  850 */       return RoamCrossCompeteRole.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  856 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  857 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  863 */       return RoamCrossCompeteRole.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  869 */       return RoamCrossCompeteRole.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  875 */       RoamCrossCompeteRole.this._xdb_verify_unsafe_();
/*  876 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  882 */       return RoamCrossCompeteRole.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  888 */       return RoamCrossCompeteRole.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  894 */       return RoamCrossCompeteRole.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  900 */       return RoamCrossCompeteRole.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  906 */       return RoamCrossCompeteRole.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  912 */       return RoamCrossCompeteRole.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  918 */       return RoamCrossCompeteRole.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoamCrossCompeteRole
/*      */   {
/*      */     private long factionid;
/*      */     
/*      */     private int duty;
/*      */     
/*      */     private int action_point;
/*      */     
/*      */     private int win_times;
/*      */     
/*      */     private int lose_times;
/*      */     
/*      */     private int win_streak;
/*      */     
/*      */     private int win_streak_awards;
/*      */     
/*      */     private int final_award;
/*      */     
/*      */     private int escape_times;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  946 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  951 */       this.factionid = -1L;
/*  952 */       this.duty = -1;
/*  953 */       this.action_point = 0;
/*  954 */       this.win_times = 0;
/*  955 */       this.lose_times = 0;
/*  956 */       this.win_streak = 0;
/*  957 */       this.win_streak_awards = 0;
/*  958 */       this.final_award = 0;
/*  959 */       this.escape_times = 0;
/*      */     }
/*      */     
/*      */     Data(xbean.RoamCrossCompeteRole _o1_)
/*      */     {
/*  964 */       if ((_o1_ instanceof RoamCrossCompeteRole)) { assign((RoamCrossCompeteRole)_o1_);
/*  965 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  966 */       } else if ((_o1_ instanceof RoamCrossCompeteRole.Const)) assign(((RoamCrossCompeteRole.Const)_o1_).nThis()); else {
/*  967 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoamCrossCompeteRole _o_) {
/*  972 */       this.factionid = _o_.factionid;
/*  973 */       this.duty = _o_.duty;
/*  974 */       this.action_point = _o_.action_point;
/*  975 */       this.win_times = _o_.win_times;
/*  976 */       this.lose_times = _o_.lose_times;
/*  977 */       this.win_streak = _o_.win_streak;
/*  978 */       this.win_streak_awards = _o_.win_streak_awards;
/*  979 */       this.final_award = _o_.final_award;
/*  980 */       this.escape_times = _o_.escape_times;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  985 */       this.factionid = _o_.factionid;
/*  986 */       this.duty = _o_.duty;
/*  987 */       this.action_point = _o_.action_point;
/*  988 */       this.win_times = _o_.win_times;
/*  989 */       this.lose_times = _o_.lose_times;
/*  990 */       this.win_streak = _o_.win_streak;
/*  991 */       this.win_streak_awards = _o_.win_streak_awards;
/*  992 */       this.final_award = _o_.final_award;
/*  993 */       this.escape_times = _o_.escape_times;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  999 */       _os_.marshal(this.factionid);
/* 1000 */       _os_.marshal(this.duty);
/* 1001 */       _os_.marshal(this.action_point);
/* 1002 */       _os_.marshal(this.win_times);
/* 1003 */       _os_.marshal(this.lose_times);
/* 1004 */       _os_.marshal(this.win_streak);
/* 1005 */       _os_.marshal(this.win_streak_awards);
/* 1006 */       _os_.marshal(this.final_award);
/* 1007 */       _os_.marshal(this.escape_times);
/* 1008 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1014 */       this.factionid = _os_.unmarshal_long();
/* 1015 */       this.duty = _os_.unmarshal_int();
/* 1016 */       this.action_point = _os_.unmarshal_int();
/* 1017 */       this.win_times = _os_.unmarshal_int();
/* 1018 */       this.lose_times = _os_.unmarshal_int();
/* 1019 */       this.win_streak = _os_.unmarshal_int();
/* 1020 */       this.win_streak_awards = _os_.unmarshal_int();
/* 1021 */       this.final_award = _os_.unmarshal_int();
/* 1022 */       this.escape_times = _os_.unmarshal_int();
/* 1023 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1029 */       int _size_ = 0;
/* 1030 */       _size_ += CodedOutputStream.computeInt64Size(1, this.factionid);
/* 1031 */       _size_ += CodedOutputStream.computeInt32Size(2, this.duty);
/* 1032 */       _size_ += CodedOutputStream.computeInt32Size(3, this.action_point);
/* 1033 */       _size_ += CodedOutputStream.computeInt32Size(4, this.win_times);
/* 1034 */       _size_ += CodedOutputStream.computeInt32Size(5, this.lose_times);
/* 1035 */       _size_ += CodedOutputStream.computeInt32Size(6, this.win_streak);
/* 1036 */       _size_ += CodedOutputStream.computeInt32Size(7, this.win_streak_awards);
/* 1037 */       _size_ += CodedOutputStream.computeInt32Size(8, this.final_award);
/* 1038 */       _size_ += CodedOutputStream.computeInt32Size(9, this.escape_times);
/* 1039 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1047 */         _output_.writeInt64(1, this.factionid);
/* 1048 */         _output_.writeInt32(2, this.duty);
/* 1049 */         _output_.writeInt32(3, this.action_point);
/* 1050 */         _output_.writeInt32(4, this.win_times);
/* 1051 */         _output_.writeInt32(5, this.lose_times);
/* 1052 */         _output_.writeInt32(6, this.win_streak);
/* 1053 */         _output_.writeInt32(7, this.win_streak_awards);
/* 1054 */         _output_.writeInt32(8, this.final_award);
/* 1055 */         _output_.writeInt32(9, this.escape_times);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1059 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1061 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1069 */         boolean done = false;
/* 1070 */         while (!done)
/*      */         {
/* 1072 */           int tag = _input_.readTag();
/* 1073 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1077 */             done = true;
/* 1078 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1082 */             this.factionid = _input_.readInt64();
/* 1083 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1087 */             this.duty = _input_.readInt32();
/* 1088 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1092 */             this.action_point = _input_.readInt32();
/* 1093 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1097 */             this.win_times = _input_.readInt32();
/* 1098 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1102 */             this.lose_times = _input_.readInt32();
/* 1103 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1107 */             this.win_streak = _input_.readInt32();
/* 1108 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1112 */             this.win_streak_awards = _input_.readInt32();
/* 1113 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1117 */             this.final_award = _input_.readInt32();
/* 1118 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1122 */             this.escape_times = _input_.readInt32();
/* 1123 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1127 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1129 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1138 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1142 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1144 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteRole copy()
/*      */     {
/* 1150 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteRole toData()
/*      */     {
/* 1156 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoamCrossCompeteRole toBean()
/*      */     {
/* 1161 */       return new RoamCrossCompeteRole(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteRole toDataIf()
/*      */     {
/* 1167 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoamCrossCompeteRole toBeanIf()
/*      */     {
/* 1172 */       return new RoamCrossCompeteRole(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1178 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1182 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1186 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1190 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1194 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1198 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1202 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFactionid()
/*      */     {
/* 1209 */       return this.factionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDuty()
/*      */     {
/* 1216 */       return this.duty;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAction_point()
/*      */     {
/* 1223 */       return this.action_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/* 1230 */       return this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_times()
/*      */     {
/* 1237 */       return this.lose_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_streak()
/*      */     {
/* 1244 */       return this.win_streak;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_streak_awards()
/*      */     {
/* 1251 */       return this.win_streak_awards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFinal_award()
/*      */     {
/* 1258 */       return this.final_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEscape_times()
/*      */     {
/* 1265 */       return this.escape_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFactionid(long _v_)
/*      */     {
/* 1272 */       this.factionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDuty(int _v_)
/*      */     {
/* 1279 */       this.duty = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAction_point(int _v_)
/*      */     {
/* 1286 */       this.action_point = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/* 1293 */       this.win_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_times(int _v_)
/*      */     {
/* 1300 */       this.lose_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_streak(int _v_)
/*      */     {
/* 1307 */       this.win_streak = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_streak_awards(int _v_)
/*      */     {
/* 1314 */       this.win_streak_awards = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinal_award(int _v_)
/*      */     {
/* 1321 */       this.final_award = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEscape_times(int _v_)
/*      */     {
/* 1328 */       this.escape_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1334 */       if (!(_o1_ instanceof Data)) return false;
/* 1335 */       Data _o_ = (Data)_o1_;
/* 1336 */       if (this.factionid != _o_.factionid) return false;
/* 1337 */       if (this.duty != _o_.duty) return false;
/* 1338 */       if (this.action_point != _o_.action_point) return false;
/* 1339 */       if (this.win_times != _o_.win_times) return false;
/* 1340 */       if (this.lose_times != _o_.lose_times) return false;
/* 1341 */       if (this.win_streak != _o_.win_streak) return false;
/* 1342 */       if (this.win_streak_awards != _o_.win_streak_awards) return false;
/* 1343 */       if (this.final_award != _o_.final_award) return false;
/* 1344 */       if (this.escape_times != _o_.escape_times) return false;
/* 1345 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1351 */       int _h_ = 0;
/* 1352 */       _h_ = (int)(_h_ + this.factionid);
/* 1353 */       _h_ += this.duty;
/* 1354 */       _h_ += this.action_point;
/* 1355 */       _h_ += this.win_times;
/* 1356 */       _h_ += this.lose_times;
/* 1357 */       _h_ += this.win_streak;
/* 1358 */       _h_ += this.win_streak_awards;
/* 1359 */       _h_ += this.final_award;
/* 1360 */       _h_ += this.escape_times;
/* 1361 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1367 */       StringBuilder _sb_ = new StringBuilder();
/* 1368 */       _sb_.append("(");
/* 1369 */       _sb_.append(this.factionid);
/* 1370 */       _sb_.append(",");
/* 1371 */       _sb_.append(this.duty);
/* 1372 */       _sb_.append(",");
/* 1373 */       _sb_.append(this.action_point);
/* 1374 */       _sb_.append(",");
/* 1375 */       _sb_.append(this.win_times);
/* 1376 */       _sb_.append(",");
/* 1377 */       _sb_.append(this.lose_times);
/* 1378 */       _sb_.append(",");
/* 1379 */       _sb_.append(this.win_streak);
/* 1380 */       _sb_.append(",");
/* 1381 */       _sb_.append(this.win_streak_awards);
/* 1382 */       _sb_.append(",");
/* 1383 */       _sb_.append(this.final_award);
/* 1384 */       _sb_.append(",");
/* 1385 */       _sb_.append(this.escape_times);
/* 1386 */       _sb_.append(")");
/* 1387 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoamCrossCompeteRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */