/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
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
/*      */ 
/*      */ public final class EveryDayQuestionAnswerInfo extends XBean implements xbean.EveryDayQuestionAnswerInfo
/*      */ {
/*      */   private LinkedList<Integer> questionlist;
/*      */   private int currentquestionidx;
/*      */   private int currentanswerpageidx;
/*      */   private int usehelpnum;
/*      */   private long awardmoney;
/*      */   private int awardexp;
/*      */   private int rightnum;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.questionlist.clear();
/*   31 */     this.currentquestionidx = 0;
/*   32 */     this.currentanswerpageidx = 0;
/*   33 */     this.usehelpnum = 0;
/*   34 */     this.awardmoney = 0L;
/*   35 */     this.awardexp = 0;
/*   36 */     this.rightnum = 0;
/*      */   }
/*      */   
/*      */   EveryDayQuestionAnswerInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.questionlist = new LinkedList();
/*      */   }
/*      */   
/*      */   public EveryDayQuestionAnswerInfo()
/*      */   {
/*   47 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public EveryDayQuestionAnswerInfo(EveryDayQuestionAnswerInfo _o_)
/*      */   {
/*   52 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   EveryDayQuestionAnswerInfo(xbean.EveryDayQuestionAnswerInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   57 */     super(_xp_, _vn_);
/*   58 */     if ((_o1_ instanceof EveryDayQuestionAnswerInfo)) { assign((EveryDayQuestionAnswerInfo)_o1_);
/*   59 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   60 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   61 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(EveryDayQuestionAnswerInfo _o_) {
/*   66 */     _o_._xdb_verify_unsafe_();
/*   67 */     this.questionlist = new LinkedList();
/*   68 */     this.questionlist.addAll(_o_.questionlist);
/*   69 */     this.currentquestionidx = _o_.currentquestionidx;
/*   70 */     this.currentanswerpageidx = _o_.currentanswerpageidx;
/*   71 */     this.usehelpnum = _o_.usehelpnum;
/*   72 */     this.awardmoney = _o_.awardmoney;
/*   73 */     this.awardexp = _o_.awardexp;
/*   74 */     this.rightnum = _o_.rightnum;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   79 */     this.questionlist = new LinkedList();
/*   80 */     this.questionlist.addAll(_o_.questionlist);
/*   81 */     this.currentquestionidx = _o_.currentquestionidx;
/*   82 */     this.currentanswerpageidx = _o_.currentanswerpageidx;
/*   83 */     this.usehelpnum = _o_.usehelpnum;
/*   84 */     this.awardmoney = _o_.awardmoney;
/*   85 */     this.awardexp = _o_.awardexp;
/*   86 */     this.rightnum = _o_.rightnum;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   92 */     _xdb_verify_unsafe_();
/*   93 */     _os_.compact_uint32(this.questionlist.size());
/*   94 */     for (Integer _v_ : this.questionlist)
/*      */     {
/*   96 */       _os_.marshal(_v_.intValue());
/*      */     }
/*   98 */     _os_.marshal(this.currentquestionidx);
/*   99 */     _os_.marshal(this.currentanswerpageidx);
/*  100 */     _os_.marshal(this.usehelpnum);
/*  101 */     _os_.marshal(this.awardmoney);
/*  102 */     _os_.marshal(this.awardexp);
/*  103 */     _os_.marshal(this.rightnum);
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  113 */       int _v_ = 0;
/*  114 */       _v_ = _os_.unmarshal_int();
/*  115 */       this.questionlist.add(Integer.valueOf(_v_));
/*      */     }
/*  117 */     this.currentquestionidx = _os_.unmarshal_int();
/*  118 */     this.currentanswerpageidx = _os_.unmarshal_int();
/*  119 */     this.usehelpnum = _os_.unmarshal_int();
/*  120 */     this.awardmoney = _os_.unmarshal_long();
/*  121 */     this.awardexp = _os_.unmarshal_int();
/*  122 */     this.rightnum = _os_.unmarshal_int();
/*  123 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  129 */     _xdb_verify_unsafe_();
/*  130 */     int _size_ = 0;
/*  131 */     for (Integer _v_ : this.questionlist)
/*      */     {
/*  133 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*      */     }
/*  135 */     _size_ += CodedOutputStream.computeInt32Size(2, this.currentquestionidx);
/*  136 */     _size_ += CodedOutputStream.computeInt32Size(3, this.currentanswerpageidx);
/*  137 */     _size_ += CodedOutputStream.computeInt32Size(4, this.usehelpnum);
/*  138 */     _size_ += CodedOutputStream.computeInt64Size(5, this.awardmoney);
/*  139 */     _size_ += CodedOutputStream.computeInt32Size(6, this.awardexp);
/*  140 */     _size_ += CodedOutputStream.computeInt32Size(7, this.rightnum);
/*  141 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  147 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  150 */       for (Integer _v_ : this.questionlist)
/*      */       {
/*  152 */         _output_.writeInt32(1, _v_.intValue());
/*      */       }
/*  154 */       _output_.writeInt32(2, this.currentquestionidx);
/*  155 */       _output_.writeInt32(3, this.currentanswerpageidx);
/*  156 */       _output_.writeInt32(4, this.usehelpnum);
/*  157 */       _output_.writeInt64(5, this.awardmoney);
/*  158 */       _output_.writeInt32(6, this.awardexp);
/*  159 */       _output_.writeInt32(7, this.rightnum);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  165 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  171 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  174 */       boolean done = false;
/*  175 */       while (!done)
/*      */       {
/*  177 */         int tag = _input_.readTag();
/*  178 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  182 */           done = true;
/*  183 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  187 */           int _v_ = 0;
/*  188 */           _v_ = _input_.readInt32();
/*  189 */           this.questionlist.add(Integer.valueOf(_v_));
/*  190 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  194 */           this.currentquestionidx = _input_.readInt32();
/*  195 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  199 */           this.currentanswerpageidx = _input_.readInt32();
/*  200 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  204 */           this.usehelpnum = _input_.readInt32();
/*  205 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  209 */           this.awardmoney = _input_.readInt64();
/*  210 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  214 */           this.awardexp = _input_.readInt32();
/*  215 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  219 */           this.rightnum = _input_.readInt32();
/*  220 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  224 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  226 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  235 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  239 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  241 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.EveryDayQuestionAnswerInfo copy()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new EveryDayQuestionAnswerInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.EveryDayQuestionAnswerInfo toData()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.EveryDayQuestionAnswerInfo toBean()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new EveryDayQuestionAnswerInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.EveryDayQuestionAnswerInfo toDataIf()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.EveryDayQuestionAnswerInfo toBeanIf()
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getQuestionlist()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return Logs.logList(new LogKey(this, "questionlist"), this.questionlist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getQuestionlistAsData()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*      */     
/*  297 */     EveryDayQuestionAnswerInfo _o_ = this;
/*  298 */     List<Integer> questionlist = new LinkedList();
/*  299 */     questionlist.addAll(_o_.questionlist);
/*  300 */     return questionlist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrentquestionidx()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return this.currentquestionidx;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrentanswerpageidx()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return this.currentanswerpageidx;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getUsehelpnum()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     return this.usehelpnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAwardmoney()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return this.awardmoney;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAwardexp()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return this.awardexp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRightnum()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return this.rightnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrentquestionidx(int _v_)
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     Logs.logIf(new LogKey(this, "currentquestionidx")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  360 */         new LogInt(this, EveryDayQuestionAnswerInfo.this.currentquestionidx)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  364 */             EveryDayQuestionAnswerInfo.this.currentquestionidx = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  368 */     });
/*  369 */     this.currentquestionidx = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrentanswerpageidx(int _v_)
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     Logs.logIf(new LogKey(this, "currentanswerpageidx")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  381 */         new LogInt(this, EveryDayQuestionAnswerInfo.this.currentanswerpageidx)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  385 */             EveryDayQuestionAnswerInfo.this.currentanswerpageidx = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  389 */     });
/*  390 */     this.currentanswerpageidx = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUsehelpnum(int _v_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     Logs.logIf(new LogKey(this, "usehelpnum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  402 */         new LogInt(this, EveryDayQuestionAnswerInfo.this.usehelpnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  406 */             EveryDayQuestionAnswerInfo.this.usehelpnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  410 */     });
/*  411 */     this.usehelpnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAwardmoney(long _v_)
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     Logs.logIf(new LogKey(this, "awardmoney")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  423 */         new xdb.logs.LogLong(this, EveryDayQuestionAnswerInfo.this.awardmoney)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  427 */             EveryDayQuestionAnswerInfo.this.awardmoney = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  431 */     });
/*  432 */     this.awardmoney = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAwardexp(int _v_)
/*      */   {
/*  439 */     _xdb_verify_unsafe_();
/*  440 */     Logs.logIf(new LogKey(this, "awardexp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  444 */         new LogInt(this, EveryDayQuestionAnswerInfo.this.awardexp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  448 */             EveryDayQuestionAnswerInfo.this.awardexp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  452 */     });
/*  453 */     this.awardexp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRightnum(int _v_)
/*      */   {
/*  460 */     _xdb_verify_unsafe_();
/*  461 */     Logs.logIf(new LogKey(this, "rightnum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  465 */         new LogInt(this, EveryDayQuestionAnswerInfo.this.rightnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  469 */             EveryDayQuestionAnswerInfo.this.rightnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  473 */     });
/*  474 */     this.rightnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  480 */     _xdb_verify_unsafe_();
/*  481 */     EveryDayQuestionAnswerInfo _o_ = null;
/*  482 */     if ((_o1_ instanceof EveryDayQuestionAnswerInfo)) { _o_ = (EveryDayQuestionAnswerInfo)_o1_;
/*  483 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  484 */       return false;
/*  485 */     if (!this.questionlist.equals(_o_.questionlist)) return false;
/*  486 */     if (this.currentquestionidx != _o_.currentquestionidx) return false;
/*  487 */     if (this.currentanswerpageidx != _o_.currentanswerpageidx) return false;
/*  488 */     if (this.usehelpnum != _o_.usehelpnum) return false;
/*  489 */     if (this.awardmoney != _o_.awardmoney) return false;
/*  490 */     if (this.awardexp != _o_.awardexp) return false;
/*  491 */     if (this.rightnum != _o_.rightnum) return false;
/*  492 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  498 */     _xdb_verify_unsafe_();
/*  499 */     int _h_ = 0;
/*  500 */     _h_ += this.questionlist.hashCode();
/*  501 */     _h_ += this.currentquestionidx;
/*  502 */     _h_ += this.currentanswerpageidx;
/*  503 */     _h_ += this.usehelpnum;
/*  504 */     _h_ = (int)(_h_ + this.awardmoney);
/*  505 */     _h_ += this.awardexp;
/*  506 */     _h_ += this.rightnum;
/*  507 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     StringBuilder _sb_ = new StringBuilder();
/*  515 */     _sb_.append("(");
/*  516 */     _sb_.append(this.questionlist);
/*  517 */     _sb_.append(",");
/*  518 */     _sb_.append(this.currentquestionidx);
/*  519 */     _sb_.append(",");
/*  520 */     _sb_.append(this.currentanswerpageidx);
/*  521 */     _sb_.append(",");
/*  522 */     _sb_.append(this.usehelpnum);
/*  523 */     _sb_.append(",");
/*  524 */     _sb_.append(this.awardmoney);
/*  525 */     _sb_.append(",");
/*  526 */     _sb_.append(this.awardexp);
/*  527 */     _sb_.append(",");
/*  528 */     _sb_.append(this.rightnum);
/*  529 */     _sb_.append(")");
/*  530 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  536 */     ListenableBean lb = new ListenableBean();
/*  537 */     lb.add(new ListenableChanged().setVarName("questionlist"));
/*  538 */     lb.add(new ListenableChanged().setVarName("currentquestionidx"));
/*  539 */     lb.add(new ListenableChanged().setVarName("currentanswerpageidx"));
/*  540 */     lb.add(new ListenableChanged().setVarName("usehelpnum"));
/*  541 */     lb.add(new ListenableChanged().setVarName("awardmoney"));
/*  542 */     lb.add(new ListenableChanged().setVarName("awardexp"));
/*  543 */     lb.add(new ListenableChanged().setVarName("rightnum"));
/*  544 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.EveryDayQuestionAnswerInfo {
/*      */     private Const() {}
/*      */     
/*      */     EveryDayQuestionAnswerInfo nThis() {
/*  551 */       return EveryDayQuestionAnswerInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  557 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.EveryDayQuestionAnswerInfo copy()
/*      */     {
/*  563 */       return EveryDayQuestionAnswerInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.EveryDayQuestionAnswerInfo toData()
/*      */     {
/*  569 */       return EveryDayQuestionAnswerInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.EveryDayQuestionAnswerInfo toBean()
/*      */     {
/*  574 */       return EveryDayQuestionAnswerInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.EveryDayQuestionAnswerInfo toDataIf()
/*      */     {
/*  580 */       return EveryDayQuestionAnswerInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.EveryDayQuestionAnswerInfo toBeanIf()
/*      */     {
/*  585 */       return EveryDayQuestionAnswerInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getQuestionlist()
/*      */     {
/*  592 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  593 */       return xdb.Consts.constList(EveryDayQuestionAnswerInfo.this.questionlist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getQuestionlistAsData()
/*      */     {
/*  599 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*      */       
/*  601 */       EveryDayQuestionAnswerInfo _o_ = EveryDayQuestionAnswerInfo.this;
/*  602 */       List<Integer> questionlist = new LinkedList();
/*  603 */       questionlist.addAll(_o_.questionlist);
/*  604 */       return questionlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrentquestionidx()
/*      */     {
/*  611 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  612 */       return EveryDayQuestionAnswerInfo.this.currentquestionidx;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrentanswerpageidx()
/*      */     {
/*  619 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  620 */       return EveryDayQuestionAnswerInfo.this.currentanswerpageidx;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUsehelpnum()
/*      */     {
/*  627 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  628 */       return EveryDayQuestionAnswerInfo.this.usehelpnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAwardmoney()
/*      */     {
/*  635 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  636 */       return EveryDayQuestionAnswerInfo.this.awardmoney;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAwardexp()
/*      */     {
/*  643 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  644 */       return EveryDayQuestionAnswerInfo.this.awardexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRightnum()
/*      */     {
/*  651 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  652 */       return EveryDayQuestionAnswerInfo.this.rightnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrentquestionidx(int _v_)
/*      */     {
/*  659 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  660 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrentanswerpageidx(int _v_)
/*      */     {
/*  667 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  668 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUsehelpnum(int _v_)
/*      */     {
/*  675 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  676 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAwardmoney(long _v_)
/*      */     {
/*  683 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  684 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAwardexp(int _v_)
/*      */     {
/*  691 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  692 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRightnum(int _v_)
/*      */     {
/*  699 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  700 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  706 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  707 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  713 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  714 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  720 */       return EveryDayQuestionAnswerInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  726 */       return EveryDayQuestionAnswerInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  732 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  733 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  739 */       return EveryDayQuestionAnswerInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  745 */       return EveryDayQuestionAnswerInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  751 */       EveryDayQuestionAnswerInfo.this._xdb_verify_unsafe_();
/*  752 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  758 */       return EveryDayQuestionAnswerInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  764 */       return EveryDayQuestionAnswerInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  770 */       return EveryDayQuestionAnswerInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  776 */       return EveryDayQuestionAnswerInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  782 */       return EveryDayQuestionAnswerInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  788 */       return EveryDayQuestionAnswerInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  794 */       return EveryDayQuestionAnswerInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.EveryDayQuestionAnswerInfo
/*      */   {
/*      */     private LinkedList<Integer> questionlist;
/*      */     
/*      */     private int currentquestionidx;
/*      */     
/*      */     private int currentanswerpageidx;
/*      */     
/*      */     private int usehelpnum;
/*      */     
/*      */     private long awardmoney;
/*      */     
/*      */     private int awardexp;
/*      */     
/*      */     private int rightnum;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  818 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  823 */       this.questionlist = new LinkedList();
/*      */     }
/*      */     
/*      */     Data(xbean.EveryDayQuestionAnswerInfo _o1_)
/*      */     {
/*  828 */       if ((_o1_ instanceof EveryDayQuestionAnswerInfo)) { assign((EveryDayQuestionAnswerInfo)_o1_);
/*  829 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  830 */       } else if ((_o1_ instanceof EveryDayQuestionAnswerInfo.Const)) assign(((EveryDayQuestionAnswerInfo.Const)_o1_).nThis()); else {
/*  831 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(EveryDayQuestionAnswerInfo _o_) {
/*  836 */       this.questionlist = new LinkedList();
/*  837 */       this.questionlist.addAll(_o_.questionlist);
/*  838 */       this.currentquestionidx = _o_.currentquestionidx;
/*  839 */       this.currentanswerpageidx = _o_.currentanswerpageidx;
/*  840 */       this.usehelpnum = _o_.usehelpnum;
/*  841 */       this.awardmoney = _o_.awardmoney;
/*  842 */       this.awardexp = _o_.awardexp;
/*  843 */       this.rightnum = _o_.rightnum;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  848 */       this.questionlist = new LinkedList();
/*  849 */       this.questionlist.addAll(_o_.questionlist);
/*  850 */       this.currentquestionidx = _o_.currentquestionidx;
/*  851 */       this.currentanswerpageidx = _o_.currentanswerpageidx;
/*  852 */       this.usehelpnum = _o_.usehelpnum;
/*  853 */       this.awardmoney = _o_.awardmoney;
/*  854 */       this.awardexp = _o_.awardexp;
/*  855 */       this.rightnum = _o_.rightnum;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  861 */       _os_.compact_uint32(this.questionlist.size());
/*  862 */       for (Integer _v_ : this.questionlist)
/*      */       {
/*  864 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  866 */       _os_.marshal(this.currentquestionidx);
/*  867 */       _os_.marshal(this.currentanswerpageidx);
/*  868 */       _os_.marshal(this.usehelpnum);
/*  869 */       _os_.marshal(this.awardmoney);
/*  870 */       _os_.marshal(this.awardexp);
/*  871 */       _os_.marshal(this.rightnum);
/*  872 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  878 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  880 */         int _v_ = 0;
/*  881 */         _v_ = _os_.unmarshal_int();
/*  882 */         this.questionlist.add(Integer.valueOf(_v_));
/*      */       }
/*  884 */       this.currentquestionidx = _os_.unmarshal_int();
/*  885 */       this.currentanswerpageidx = _os_.unmarshal_int();
/*  886 */       this.usehelpnum = _os_.unmarshal_int();
/*  887 */       this.awardmoney = _os_.unmarshal_long();
/*  888 */       this.awardexp = _os_.unmarshal_int();
/*  889 */       this.rightnum = _os_.unmarshal_int();
/*  890 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  896 */       int _size_ = 0;
/*  897 */       for (Integer _v_ : this.questionlist)
/*      */       {
/*  899 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*      */       }
/*  901 */       _size_ += CodedOutputStream.computeInt32Size(2, this.currentquestionidx);
/*  902 */       _size_ += CodedOutputStream.computeInt32Size(3, this.currentanswerpageidx);
/*  903 */       _size_ += CodedOutputStream.computeInt32Size(4, this.usehelpnum);
/*  904 */       _size_ += CodedOutputStream.computeInt64Size(5, this.awardmoney);
/*  905 */       _size_ += CodedOutputStream.computeInt32Size(6, this.awardexp);
/*  906 */       _size_ += CodedOutputStream.computeInt32Size(7, this.rightnum);
/*  907 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  915 */         for (Integer _v_ : this.questionlist)
/*      */         {
/*  917 */           _output_.writeInt32(1, _v_.intValue());
/*      */         }
/*  919 */         _output_.writeInt32(2, this.currentquestionidx);
/*  920 */         _output_.writeInt32(3, this.currentanswerpageidx);
/*  921 */         _output_.writeInt32(4, this.usehelpnum);
/*  922 */         _output_.writeInt64(5, this.awardmoney);
/*  923 */         _output_.writeInt32(6, this.awardexp);
/*  924 */         _output_.writeInt32(7, this.rightnum);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  928 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  930 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  938 */         boolean done = false;
/*  939 */         while (!done)
/*      */         {
/*  941 */           int tag = _input_.readTag();
/*  942 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  946 */             done = true;
/*  947 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  951 */             int _v_ = 0;
/*  952 */             _v_ = _input_.readInt32();
/*  953 */             this.questionlist.add(Integer.valueOf(_v_));
/*  954 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  958 */             this.currentquestionidx = _input_.readInt32();
/*  959 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  963 */             this.currentanswerpageidx = _input_.readInt32();
/*  964 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  968 */             this.usehelpnum = _input_.readInt32();
/*  969 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  973 */             this.awardmoney = _input_.readInt64();
/*  974 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  978 */             this.awardexp = _input_.readInt32();
/*  979 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/*  983 */             this.rightnum = _input_.readInt32();
/*  984 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  988 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  990 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  999 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1003 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1005 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.EveryDayQuestionAnswerInfo copy()
/*      */     {
/* 1011 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.EveryDayQuestionAnswerInfo toData()
/*      */     {
/* 1017 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.EveryDayQuestionAnswerInfo toBean()
/*      */     {
/* 1022 */       return new EveryDayQuestionAnswerInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.EveryDayQuestionAnswerInfo toDataIf()
/*      */     {
/* 1028 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.EveryDayQuestionAnswerInfo toBeanIf()
/*      */     {
/* 1033 */       return new EveryDayQuestionAnswerInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1039 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1043 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1047 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1051 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1055 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1059 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1063 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getQuestionlist()
/*      */     {
/* 1070 */       return this.questionlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getQuestionlistAsData()
/*      */     {
/* 1077 */       return this.questionlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrentquestionidx()
/*      */     {
/* 1084 */       return this.currentquestionidx;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrentanswerpageidx()
/*      */     {
/* 1091 */       return this.currentanswerpageidx;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUsehelpnum()
/*      */     {
/* 1098 */       return this.usehelpnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAwardmoney()
/*      */     {
/* 1105 */       return this.awardmoney;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAwardexp()
/*      */     {
/* 1112 */       return this.awardexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRightnum()
/*      */     {
/* 1119 */       return this.rightnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrentquestionidx(int _v_)
/*      */     {
/* 1126 */       this.currentquestionidx = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrentanswerpageidx(int _v_)
/*      */     {
/* 1133 */       this.currentanswerpageidx = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUsehelpnum(int _v_)
/*      */     {
/* 1140 */       this.usehelpnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAwardmoney(long _v_)
/*      */     {
/* 1147 */       this.awardmoney = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAwardexp(int _v_)
/*      */     {
/* 1154 */       this.awardexp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRightnum(int _v_)
/*      */     {
/* 1161 */       this.rightnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1167 */       if (!(_o1_ instanceof Data)) return false;
/* 1168 */       Data _o_ = (Data)_o1_;
/* 1169 */       if (!this.questionlist.equals(_o_.questionlist)) return false;
/* 1170 */       if (this.currentquestionidx != _o_.currentquestionidx) return false;
/* 1171 */       if (this.currentanswerpageidx != _o_.currentanswerpageidx) return false;
/* 1172 */       if (this.usehelpnum != _o_.usehelpnum) return false;
/* 1173 */       if (this.awardmoney != _o_.awardmoney) return false;
/* 1174 */       if (this.awardexp != _o_.awardexp) return false;
/* 1175 */       if (this.rightnum != _o_.rightnum) return false;
/* 1176 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1182 */       int _h_ = 0;
/* 1183 */       _h_ += this.questionlist.hashCode();
/* 1184 */       _h_ += this.currentquestionidx;
/* 1185 */       _h_ += this.currentanswerpageidx;
/* 1186 */       _h_ += this.usehelpnum;
/* 1187 */       _h_ = (int)(_h_ + this.awardmoney);
/* 1188 */       _h_ += this.awardexp;
/* 1189 */       _h_ += this.rightnum;
/* 1190 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1196 */       StringBuilder _sb_ = new StringBuilder();
/* 1197 */       _sb_.append("(");
/* 1198 */       _sb_.append(this.questionlist);
/* 1199 */       _sb_.append(",");
/* 1200 */       _sb_.append(this.currentquestionidx);
/* 1201 */       _sb_.append(",");
/* 1202 */       _sb_.append(this.currentanswerpageidx);
/* 1203 */       _sb_.append(",");
/* 1204 */       _sb_.append(this.usehelpnum);
/* 1205 */       _sb_.append(",");
/* 1206 */       _sb_.append(this.awardmoney);
/* 1207 */       _sb_.append(",");
/* 1208 */       _sb_.append(this.awardexp);
/* 1209 */       _sb_.append(",");
/* 1210 */       _sb_.append(this.rightnum);
/* 1211 */       _sb_.append(")");
/* 1212 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\EveryDayQuestionAnswerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */