/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class Ladder extends XBean implements xbean.Ladder
/*      */ {
/*      */   private int score;
/*      */   private int stage;
/*      */   private int wincount;
/*      */   private int losecount;
/*      */   private SetX<Integer> awardstages;
/*      */   private long inittime;
/*      */   private long weekinittime;
/*      */   private int weekfightcount;
/*      */   private long weekgotfightscore;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.score = 0;
/*   35 */     this.stage = 1;
/*   36 */     this.wincount = 0;
/*   37 */     this.losecount = 0;
/*   38 */     this.awardstages.clear();
/*   39 */     this.inittime = 0L;
/*   40 */     this.weekinittime = 0L;
/*   41 */     this.weekfightcount = 0;
/*   42 */     this.weekgotfightscore = 0L;
/*      */   }
/*      */   
/*      */   Ladder(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.stage = 1;
/*   49 */     this.awardstages = new SetX();
/*      */   }
/*      */   
/*      */   public Ladder()
/*      */   {
/*   54 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Ladder(Ladder _o_)
/*      */   {
/*   59 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Ladder(xbean.Ladder _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   64 */     super(_xp_, _vn_);
/*   65 */     if ((_o1_ instanceof Ladder)) { assign((Ladder)_o1_);
/*   66 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   67 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   68 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Ladder _o_) {
/*   73 */     _o_._xdb_verify_unsafe_();
/*   74 */     this.score = _o_.score;
/*   75 */     this.stage = _o_.stage;
/*   76 */     this.wincount = _o_.wincount;
/*   77 */     this.losecount = _o_.losecount;
/*   78 */     this.awardstages = new SetX();
/*   79 */     this.awardstages.addAll(_o_.awardstages);
/*   80 */     this.inittime = _o_.inittime;
/*   81 */     this.weekinittime = _o_.weekinittime;
/*   82 */     this.weekfightcount = _o_.weekfightcount;
/*   83 */     this.weekgotfightscore = _o_.weekgotfightscore;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   88 */     this.score = _o_.score;
/*   89 */     this.stage = _o_.stage;
/*   90 */     this.wincount = _o_.wincount;
/*   91 */     this.losecount = _o_.losecount;
/*   92 */     this.awardstages = new SetX();
/*   93 */     this.awardstages.addAll(_o_.awardstages);
/*   94 */     this.inittime = _o_.inittime;
/*   95 */     this.weekinittime = _o_.weekinittime;
/*   96 */     this.weekfightcount = _o_.weekfightcount;
/*   97 */     this.weekgotfightscore = _o_.weekgotfightscore;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     _os_.marshal(this.score);
/*  105 */     _os_.marshal(this.stage);
/*  106 */     _os_.marshal(this.wincount);
/*  107 */     _os_.marshal(this.losecount);
/*  108 */     _os_.compact_uint32(this.awardstages.size());
/*  109 */     for (Integer _v_ : this.awardstages)
/*      */     {
/*  111 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  113 */     _os_.marshal(this.inittime);
/*  114 */     _os_.marshal(this.weekinittime);
/*  115 */     _os_.marshal(this.weekfightcount);
/*  116 */     _os_.marshal(this.weekgotfightscore);
/*  117 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  123 */     _xdb_verify_unsafe_();
/*  124 */     this.score = _os_.unmarshal_int();
/*  125 */     this.stage = _os_.unmarshal_int();
/*  126 */     this.wincount = _os_.unmarshal_int();
/*  127 */     this.losecount = _os_.unmarshal_int();
/*  128 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  130 */       int _v_ = 0;
/*  131 */       _v_ = _os_.unmarshal_int();
/*  132 */       this.awardstages.add(Integer.valueOf(_v_));
/*      */     }
/*  134 */     this.inittime = _os_.unmarshal_long();
/*  135 */     this.weekinittime = _os_.unmarshal_long();
/*  136 */     this.weekfightcount = _os_.unmarshal_int();
/*  137 */     this.weekgotfightscore = _os_.unmarshal_long();
/*  138 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*  145 */     int _size_ = 0;
/*  146 */     _size_ += CodedOutputStream.computeInt32Size(1, this.score);
/*  147 */     _size_ += CodedOutputStream.computeInt32Size(2, this.stage);
/*  148 */     _size_ += CodedOutputStream.computeInt32Size(3, this.wincount);
/*  149 */     _size_ += CodedOutputStream.computeInt32Size(4, this.losecount);
/*  150 */     for (Integer _v_ : this.awardstages)
/*      */     {
/*  152 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  154 */     _size_ += CodedOutputStream.computeInt64Size(7, this.inittime);
/*  155 */     _size_ += CodedOutputStream.computeInt64Size(8, this.weekinittime);
/*  156 */     _size_ += CodedOutputStream.computeInt32Size(9, this.weekfightcount);
/*  157 */     _size_ += CodedOutputStream.computeInt64Size(10, this.weekgotfightscore);
/*  158 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  167 */       _output_.writeInt32(1, this.score);
/*  168 */       _output_.writeInt32(2, this.stage);
/*  169 */       _output_.writeInt32(3, this.wincount);
/*  170 */       _output_.writeInt32(4, this.losecount);
/*  171 */       for (Integer _v_ : this.awardstages)
/*      */       {
/*  173 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*  175 */       _output_.writeInt64(7, this.inittime);
/*  176 */       _output_.writeInt64(8, this.weekinittime);
/*  177 */       _output_.writeInt32(9, this.weekfightcount);
/*  178 */       _output_.writeInt64(10, this.weekgotfightscore);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  182 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  184 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  190 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  193 */       boolean done = false;
/*  194 */       while (!done)
/*      */       {
/*  196 */         int tag = _input_.readTag();
/*  197 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  201 */           done = true;
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  206 */           this.score = _input_.readInt32();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  211 */           this.stage = _input_.readInt32();
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  216 */           this.wincount = _input_.readInt32();
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  221 */           this.losecount = _input_.readInt32();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  226 */           int _v_ = 0;
/*  227 */           _v_ = _input_.readInt32();
/*  228 */           this.awardstages.add(Integer.valueOf(_v_));
/*  229 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  233 */           this.inittime = _input_.readInt64();
/*  234 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  238 */           this.weekinittime = _input_.readInt64();
/*  239 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  243 */           this.weekfightcount = _input_.readInt32();
/*  244 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  248 */           this.weekgotfightscore = _input_.readInt64();
/*  249 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  253 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  255 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  264 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  268 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  270 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Ladder copy()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return new Ladder(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Ladder toData()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Ladder toBean()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return new Ladder(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Ladder toDataIf()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Ladder toBeanIf()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getScore()
/*      */   {
/*  317 */     _xdb_verify_unsafe_();
/*  318 */     return this.score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStage()
/*      */   {
/*  325 */     _xdb_verify_unsafe_();
/*  326 */     return this.stage;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWincount()
/*      */   {
/*  333 */     _xdb_verify_unsafe_();
/*  334 */     return this.wincount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLosecount()
/*      */   {
/*  341 */     _xdb_verify_unsafe_();
/*  342 */     return this.losecount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getAwardstages()
/*      */   {
/*  349 */     _xdb_verify_unsafe_();
/*  350 */     return Logs.logSet(new LogKey(this, "awardstages"), this.awardstages);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getAwardstagesAsData()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*      */     
/*  358 */     Ladder _o_ = this;
/*  359 */     Set<Integer> awardstages = new SetX();
/*  360 */     awardstages.addAll(_o_.awardstages);
/*  361 */     return awardstages;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInittime()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     return this.inittime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWeekinittime()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     return this.weekinittime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWeekfightcount()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     return this.weekfightcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWeekgotfightscore()
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*  393 */     return this.weekgotfightscore;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setScore(int _v_)
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     Logs.logIf(new LogKey(this, "score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  405 */         new LogInt(this, Ladder.this.score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  409 */             Ladder.this.score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  413 */     });
/*  414 */     this.score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStage(int _v_)
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     Logs.logIf(new LogKey(this, "stage")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  426 */         new LogInt(this, Ladder.this.stage)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  430 */             Ladder.this.stage = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  434 */     });
/*  435 */     this.stage = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWincount(int _v_)
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     Logs.logIf(new LogKey(this, "wincount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  447 */         new LogInt(this, Ladder.this.wincount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  451 */             Ladder.this.wincount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  455 */     });
/*  456 */     this.wincount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLosecount(int _v_)
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*  464 */     Logs.logIf(new LogKey(this, "losecount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  468 */         new LogInt(this, Ladder.this.losecount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  472 */             Ladder.this.losecount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  476 */     });
/*  477 */     this.losecount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInittime(long _v_)
/*      */   {
/*  484 */     _xdb_verify_unsafe_();
/*  485 */     Logs.logIf(new LogKey(this, "inittime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  489 */         new LogLong(this, Ladder.this.inittime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  493 */             Ladder.this.inittime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  497 */     });
/*  498 */     this.inittime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWeekinittime(long _v_)
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     Logs.logIf(new LogKey(this, "weekinittime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  510 */         new LogLong(this, Ladder.this.weekinittime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  514 */             Ladder.this.weekinittime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  518 */     });
/*  519 */     this.weekinittime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWeekfightcount(int _v_)
/*      */   {
/*  526 */     _xdb_verify_unsafe_();
/*  527 */     Logs.logIf(new LogKey(this, "weekfightcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  531 */         new LogInt(this, Ladder.this.weekfightcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  535 */             Ladder.this.weekfightcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  539 */     });
/*  540 */     this.weekfightcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWeekgotfightscore(long _v_)
/*      */   {
/*  547 */     _xdb_verify_unsafe_();
/*  548 */     Logs.logIf(new LogKey(this, "weekgotfightscore")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  552 */         new LogLong(this, Ladder.this.weekgotfightscore)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  556 */             Ladder.this.weekgotfightscore = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  560 */     });
/*  561 */     this.weekgotfightscore = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  567 */     _xdb_verify_unsafe_();
/*  568 */     Ladder _o_ = null;
/*  569 */     if ((_o1_ instanceof Ladder)) { _o_ = (Ladder)_o1_;
/*  570 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  571 */       return false;
/*  572 */     if (this.score != _o_.score) return false;
/*  573 */     if (this.stage != _o_.stage) return false;
/*  574 */     if (this.wincount != _o_.wincount) return false;
/*  575 */     if (this.losecount != _o_.losecount) return false;
/*  576 */     if (!this.awardstages.equals(_o_.awardstages)) return false;
/*  577 */     if (this.inittime != _o_.inittime) return false;
/*  578 */     if (this.weekinittime != _o_.weekinittime) return false;
/*  579 */     if (this.weekfightcount != _o_.weekfightcount) return false;
/*  580 */     if (this.weekgotfightscore != _o_.weekgotfightscore) return false;
/*  581 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  587 */     _xdb_verify_unsafe_();
/*  588 */     int _h_ = 0;
/*  589 */     _h_ += this.score;
/*  590 */     _h_ += this.stage;
/*  591 */     _h_ += this.wincount;
/*  592 */     _h_ += this.losecount;
/*  593 */     _h_ += this.awardstages.hashCode();
/*  594 */     _h_ = (int)(_h_ + this.inittime);
/*  595 */     _h_ = (int)(_h_ + this.weekinittime);
/*  596 */     _h_ += this.weekfightcount;
/*  597 */     _h_ = (int)(_h_ + this.weekgotfightscore);
/*  598 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  604 */     _xdb_verify_unsafe_();
/*  605 */     StringBuilder _sb_ = new StringBuilder();
/*  606 */     _sb_.append("(");
/*  607 */     _sb_.append(this.score);
/*  608 */     _sb_.append(",");
/*  609 */     _sb_.append(this.stage);
/*  610 */     _sb_.append(",");
/*  611 */     _sb_.append(this.wincount);
/*  612 */     _sb_.append(",");
/*  613 */     _sb_.append(this.losecount);
/*  614 */     _sb_.append(",");
/*  615 */     _sb_.append(this.awardstages);
/*  616 */     _sb_.append(",");
/*  617 */     _sb_.append(this.inittime);
/*  618 */     _sb_.append(",");
/*  619 */     _sb_.append(this.weekinittime);
/*  620 */     _sb_.append(",");
/*  621 */     _sb_.append(this.weekfightcount);
/*  622 */     _sb_.append(",");
/*  623 */     _sb_.append(this.weekgotfightscore);
/*  624 */     _sb_.append(")");
/*  625 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  631 */     ListenableBean lb = new ListenableBean();
/*  632 */     lb.add(new ListenableChanged().setVarName("score"));
/*  633 */     lb.add(new ListenableChanged().setVarName("stage"));
/*  634 */     lb.add(new ListenableChanged().setVarName("wincount"));
/*  635 */     lb.add(new ListenableChanged().setVarName("losecount"));
/*  636 */     lb.add(new xdb.logs.ListenableSet().setVarName("awardstages"));
/*  637 */     lb.add(new ListenableChanged().setVarName("inittime"));
/*  638 */     lb.add(new ListenableChanged().setVarName("weekinittime"));
/*  639 */     lb.add(new ListenableChanged().setVarName("weekfightcount"));
/*  640 */     lb.add(new ListenableChanged().setVarName("weekgotfightscore"));
/*  641 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Ladder {
/*      */     private Const() {}
/*      */     
/*      */     Ladder nThis() {
/*  648 */       return Ladder.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  654 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Ladder copy()
/*      */     {
/*  660 */       return Ladder.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Ladder toData()
/*      */     {
/*  666 */       return Ladder.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Ladder toBean()
/*      */     {
/*  671 */       return Ladder.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Ladder toDataIf()
/*      */     {
/*  677 */       return Ladder.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Ladder toBeanIf()
/*      */     {
/*  682 */       return Ladder.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getScore()
/*      */     {
/*  689 */       Ladder.this._xdb_verify_unsafe_();
/*  690 */       return Ladder.this.score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/*  697 */       Ladder.this._xdb_verify_unsafe_();
/*  698 */       return Ladder.this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWincount()
/*      */     {
/*  705 */       Ladder.this._xdb_verify_unsafe_();
/*  706 */       return Ladder.this.wincount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLosecount()
/*      */     {
/*  713 */       Ladder.this._xdb_verify_unsafe_();
/*  714 */       return Ladder.this.losecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAwardstages()
/*      */     {
/*  721 */       Ladder.this._xdb_verify_unsafe_();
/*  722 */       return xdb.Consts.constSet(Ladder.this.awardstages);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getAwardstagesAsData()
/*      */     {
/*  728 */       Ladder.this._xdb_verify_unsafe_();
/*      */       
/*  730 */       Ladder _o_ = Ladder.this;
/*  731 */       Set<Integer> awardstages = new SetX();
/*  732 */       awardstages.addAll(_o_.awardstages);
/*  733 */       return awardstages;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInittime()
/*      */     {
/*  740 */       Ladder.this._xdb_verify_unsafe_();
/*  741 */       return Ladder.this.inittime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWeekinittime()
/*      */     {
/*  748 */       Ladder.this._xdb_verify_unsafe_();
/*  749 */       return Ladder.this.weekinittime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWeekfightcount()
/*      */     {
/*  756 */       Ladder.this._xdb_verify_unsafe_();
/*  757 */       return Ladder.this.weekfightcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWeekgotfightscore()
/*      */     {
/*  764 */       Ladder.this._xdb_verify_unsafe_();
/*  765 */       return Ladder.this.weekgotfightscore;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setScore(int _v_)
/*      */     {
/*  772 */       Ladder.this._xdb_verify_unsafe_();
/*  773 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/*  780 */       Ladder.this._xdb_verify_unsafe_();
/*  781 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWincount(int _v_)
/*      */     {
/*  788 */       Ladder.this._xdb_verify_unsafe_();
/*  789 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLosecount(int _v_)
/*      */     {
/*  796 */       Ladder.this._xdb_verify_unsafe_();
/*  797 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInittime(long _v_)
/*      */     {
/*  804 */       Ladder.this._xdb_verify_unsafe_();
/*  805 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekinittime(long _v_)
/*      */     {
/*  812 */       Ladder.this._xdb_verify_unsafe_();
/*  813 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekfightcount(int _v_)
/*      */     {
/*  820 */       Ladder.this._xdb_verify_unsafe_();
/*  821 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekgotfightscore(long _v_)
/*      */     {
/*  828 */       Ladder.this._xdb_verify_unsafe_();
/*  829 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  835 */       Ladder.this._xdb_verify_unsafe_();
/*  836 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  842 */       Ladder.this._xdb_verify_unsafe_();
/*  843 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  849 */       return Ladder.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  855 */       return Ladder.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  861 */       Ladder.this._xdb_verify_unsafe_();
/*  862 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  868 */       return Ladder.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  874 */       return Ladder.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  880 */       Ladder.this._xdb_verify_unsafe_();
/*  881 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  887 */       return Ladder.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  893 */       return Ladder.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  899 */       return Ladder.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  905 */       return Ladder.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  911 */       return Ladder.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  917 */       return Ladder.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  923 */       return Ladder.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Ladder
/*      */   {
/*      */     private int score;
/*      */     
/*      */     private int stage;
/*      */     
/*      */     private int wincount;
/*      */     
/*      */     private int losecount;
/*      */     
/*      */     private HashSet<Integer> awardstages;
/*      */     
/*      */     private long inittime;
/*      */     
/*      */     private long weekinittime;
/*      */     
/*      */     private int weekfightcount;
/*      */     
/*      */     private long weekgotfightscore;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  951 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  956 */       this.stage = 1;
/*  957 */       this.awardstages = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.Ladder _o1_)
/*      */     {
/*  962 */       if ((_o1_ instanceof Ladder)) { assign((Ladder)_o1_);
/*  963 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  964 */       } else if ((_o1_ instanceof Ladder.Const)) assign(((Ladder.Const)_o1_).nThis()); else {
/*  965 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Ladder _o_) {
/*  970 */       this.score = _o_.score;
/*  971 */       this.stage = _o_.stage;
/*  972 */       this.wincount = _o_.wincount;
/*  973 */       this.losecount = _o_.losecount;
/*  974 */       this.awardstages = new HashSet();
/*  975 */       this.awardstages.addAll(_o_.awardstages);
/*  976 */       this.inittime = _o_.inittime;
/*  977 */       this.weekinittime = _o_.weekinittime;
/*  978 */       this.weekfightcount = _o_.weekfightcount;
/*  979 */       this.weekgotfightscore = _o_.weekgotfightscore;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  984 */       this.score = _o_.score;
/*  985 */       this.stage = _o_.stage;
/*  986 */       this.wincount = _o_.wincount;
/*  987 */       this.losecount = _o_.losecount;
/*  988 */       this.awardstages = new HashSet();
/*  989 */       this.awardstages.addAll(_o_.awardstages);
/*  990 */       this.inittime = _o_.inittime;
/*  991 */       this.weekinittime = _o_.weekinittime;
/*  992 */       this.weekfightcount = _o_.weekfightcount;
/*  993 */       this.weekgotfightscore = _o_.weekgotfightscore;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  999 */       _os_.marshal(this.score);
/* 1000 */       _os_.marshal(this.stage);
/* 1001 */       _os_.marshal(this.wincount);
/* 1002 */       _os_.marshal(this.losecount);
/* 1003 */       _os_.compact_uint32(this.awardstages.size());
/* 1004 */       for (Integer _v_ : this.awardstages)
/*      */       {
/* 1006 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1008 */       _os_.marshal(this.inittime);
/* 1009 */       _os_.marshal(this.weekinittime);
/* 1010 */       _os_.marshal(this.weekfightcount);
/* 1011 */       _os_.marshal(this.weekgotfightscore);
/* 1012 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1018 */       this.score = _os_.unmarshal_int();
/* 1019 */       this.stage = _os_.unmarshal_int();
/* 1020 */       this.wincount = _os_.unmarshal_int();
/* 1021 */       this.losecount = _os_.unmarshal_int();
/* 1022 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1024 */         int _v_ = 0;
/* 1025 */         _v_ = _os_.unmarshal_int();
/* 1026 */         this.awardstages.add(Integer.valueOf(_v_));
/*      */       }
/* 1028 */       this.inittime = _os_.unmarshal_long();
/* 1029 */       this.weekinittime = _os_.unmarshal_long();
/* 1030 */       this.weekfightcount = _os_.unmarshal_int();
/* 1031 */       this.weekgotfightscore = _os_.unmarshal_long();
/* 1032 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1038 */       int _size_ = 0;
/* 1039 */       _size_ += CodedOutputStream.computeInt32Size(1, this.score);
/* 1040 */       _size_ += CodedOutputStream.computeInt32Size(2, this.stage);
/* 1041 */       _size_ += CodedOutputStream.computeInt32Size(3, this.wincount);
/* 1042 */       _size_ += CodedOutputStream.computeInt32Size(4, this.losecount);
/* 1043 */       for (Integer _v_ : this.awardstages)
/*      */       {
/* 1045 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/* 1047 */       _size_ += CodedOutputStream.computeInt64Size(7, this.inittime);
/* 1048 */       _size_ += CodedOutputStream.computeInt64Size(8, this.weekinittime);
/* 1049 */       _size_ += CodedOutputStream.computeInt32Size(9, this.weekfightcount);
/* 1050 */       _size_ += CodedOutputStream.computeInt64Size(10, this.weekgotfightscore);
/* 1051 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1059 */         _output_.writeInt32(1, this.score);
/* 1060 */         _output_.writeInt32(2, this.stage);
/* 1061 */         _output_.writeInt32(3, this.wincount);
/* 1062 */         _output_.writeInt32(4, this.losecount);
/* 1063 */         for (Integer _v_ : this.awardstages)
/*      */         {
/* 1065 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/* 1067 */         _output_.writeInt64(7, this.inittime);
/* 1068 */         _output_.writeInt64(8, this.weekinittime);
/* 1069 */         _output_.writeInt32(9, this.weekfightcount);
/* 1070 */         _output_.writeInt64(10, this.weekgotfightscore);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1074 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1076 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1084 */         boolean done = false;
/* 1085 */         while (!done)
/*      */         {
/* 1087 */           int tag = _input_.readTag();
/* 1088 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1092 */             done = true;
/* 1093 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1097 */             this.score = _input_.readInt32();
/* 1098 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1102 */             this.stage = _input_.readInt32();
/* 1103 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1107 */             this.wincount = _input_.readInt32();
/* 1108 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1112 */             this.losecount = _input_.readInt32();
/* 1113 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1117 */             int _v_ = 0;
/* 1118 */             _v_ = _input_.readInt32();
/* 1119 */             this.awardstages.add(Integer.valueOf(_v_));
/* 1120 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1124 */             this.inittime = _input_.readInt64();
/* 1125 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1129 */             this.weekinittime = _input_.readInt64();
/* 1130 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1134 */             this.weekfightcount = _input_.readInt32();
/* 1135 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1139 */             this.weekgotfightscore = _input_.readInt64();
/* 1140 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1144 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1146 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1155 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1159 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1161 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Ladder copy()
/*      */     {
/* 1167 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Ladder toData()
/*      */     {
/* 1173 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Ladder toBean()
/*      */     {
/* 1178 */       return new Ladder(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Ladder toDataIf()
/*      */     {
/* 1184 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Ladder toBeanIf()
/*      */     {
/* 1189 */       return new Ladder(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1195 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1199 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1203 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1207 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1211 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1215 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1219 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getScore()
/*      */     {
/* 1226 */       return this.score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/* 1233 */       return this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWincount()
/*      */     {
/* 1240 */       return this.wincount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLosecount()
/*      */     {
/* 1247 */       return this.losecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAwardstages()
/*      */     {
/* 1254 */       return this.awardstages;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAwardstagesAsData()
/*      */     {
/* 1261 */       return this.awardstages;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInittime()
/*      */     {
/* 1268 */       return this.inittime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWeekinittime()
/*      */     {
/* 1275 */       return this.weekinittime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWeekfightcount()
/*      */     {
/* 1282 */       return this.weekfightcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWeekgotfightscore()
/*      */     {
/* 1289 */       return this.weekgotfightscore;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setScore(int _v_)
/*      */     {
/* 1296 */       this.score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/* 1303 */       this.stage = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWincount(int _v_)
/*      */     {
/* 1310 */       this.wincount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLosecount(int _v_)
/*      */     {
/* 1317 */       this.losecount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInittime(long _v_)
/*      */     {
/* 1324 */       this.inittime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekinittime(long _v_)
/*      */     {
/* 1331 */       this.weekinittime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekfightcount(int _v_)
/*      */     {
/* 1338 */       this.weekfightcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekgotfightscore(long _v_)
/*      */     {
/* 1345 */       this.weekgotfightscore = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1351 */       if (!(_o1_ instanceof Data)) return false;
/* 1352 */       Data _o_ = (Data)_o1_;
/* 1353 */       if (this.score != _o_.score) return false;
/* 1354 */       if (this.stage != _o_.stage) return false;
/* 1355 */       if (this.wincount != _o_.wincount) return false;
/* 1356 */       if (this.losecount != _o_.losecount) return false;
/* 1357 */       if (!this.awardstages.equals(_o_.awardstages)) return false;
/* 1358 */       if (this.inittime != _o_.inittime) return false;
/* 1359 */       if (this.weekinittime != _o_.weekinittime) return false;
/* 1360 */       if (this.weekfightcount != _o_.weekfightcount) return false;
/* 1361 */       if (this.weekgotfightscore != _o_.weekgotfightscore) return false;
/* 1362 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1368 */       int _h_ = 0;
/* 1369 */       _h_ += this.score;
/* 1370 */       _h_ += this.stage;
/* 1371 */       _h_ += this.wincount;
/* 1372 */       _h_ += this.losecount;
/* 1373 */       _h_ += this.awardstages.hashCode();
/* 1374 */       _h_ = (int)(_h_ + this.inittime);
/* 1375 */       _h_ = (int)(_h_ + this.weekinittime);
/* 1376 */       _h_ += this.weekfightcount;
/* 1377 */       _h_ = (int)(_h_ + this.weekgotfightscore);
/* 1378 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1384 */       StringBuilder _sb_ = new StringBuilder();
/* 1385 */       _sb_.append("(");
/* 1386 */       _sb_.append(this.score);
/* 1387 */       _sb_.append(",");
/* 1388 */       _sb_.append(this.stage);
/* 1389 */       _sb_.append(",");
/* 1390 */       _sb_.append(this.wincount);
/* 1391 */       _sb_.append(",");
/* 1392 */       _sb_.append(this.losecount);
/* 1393 */       _sb_.append(",");
/* 1394 */       _sb_.append(this.awardstages);
/* 1395 */       _sb_.append(",");
/* 1396 */       _sb_.append(this.inittime);
/* 1397 */       _sb_.append(",");
/* 1398 */       _sb_.append(this.weekinittime);
/* 1399 */       _sb_.append(",");
/* 1400 */       _sb_.append(this.weekfightcount);
/* 1401 */       _sb_.append(",");
/* 1402 */       _sb_.append(this.weekgotfightscore);
/* 1403 */       _sb_.append(")");
/* 1404 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Ladder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */