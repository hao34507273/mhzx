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
/*      */ public final class KeJuInfo extends XBean implements xbean.KeJuInfo
/*      */ {
/*      */   private ArrayList<Integer> questionlist;
/*      */   private int state;
/*      */   private int rightnum;
/*      */   private int answernum;
/*      */   private boolean ispasshuishi;
/*      */   private long starttime;
/*      */   private long finishtime;
/*      */   private int punishtime;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.questionlist.clear();
/*   33 */     this.state = 0;
/*   34 */     this.rightnum = 0;
/*   35 */     this.answernum = 0;
/*   36 */     this.ispasshuishi = false;
/*   37 */     this.starttime = 0L;
/*   38 */     this.finishtime = 0L;
/*   39 */     this.punishtime = 0;
/*      */   }
/*      */   
/*      */   KeJuInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.questionlist = new ArrayList();
/*      */   }
/*      */   
/*      */   public KeJuInfo()
/*      */   {
/*   50 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public KeJuInfo(KeJuInfo _o_)
/*      */   {
/*   55 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   KeJuInfo(xbean.KeJuInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   60 */     super(_xp_, _vn_);
/*   61 */     if ((_o1_ instanceof KeJuInfo)) { assign((KeJuInfo)_o1_);
/*   62 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   63 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   64 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(KeJuInfo _o_) {
/*   69 */     _o_._xdb_verify_unsafe_();
/*   70 */     this.questionlist = new ArrayList();
/*   71 */     this.questionlist.addAll(_o_.questionlist);
/*   72 */     this.state = _o_.state;
/*   73 */     this.rightnum = _o_.rightnum;
/*   74 */     this.answernum = _o_.answernum;
/*   75 */     this.ispasshuishi = _o_.ispasshuishi;
/*   76 */     this.starttime = _o_.starttime;
/*   77 */     this.finishtime = _o_.finishtime;
/*   78 */     this.punishtime = _o_.punishtime;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   83 */     this.questionlist = new ArrayList();
/*   84 */     this.questionlist.addAll(_o_.questionlist);
/*   85 */     this.state = _o_.state;
/*   86 */     this.rightnum = _o_.rightnum;
/*   87 */     this.answernum = _o_.answernum;
/*   88 */     this.ispasshuishi = _o_.ispasshuishi;
/*   89 */     this.starttime = _o_.starttime;
/*   90 */     this.finishtime = _o_.finishtime;
/*   91 */     this.punishtime = _o_.punishtime;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   97 */     _xdb_verify_unsafe_();
/*   98 */     _os_.compact_uint32(this.questionlist.size());
/*   99 */     for (Integer _v_ : this.questionlist)
/*      */     {
/*  101 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  103 */     _os_.marshal(this.state);
/*  104 */     _os_.marshal(this.rightnum);
/*  105 */     _os_.marshal(this.answernum);
/*  106 */     _os_.marshal(this.ispasshuishi);
/*  107 */     _os_.marshal(this.starttime);
/*  108 */     _os_.marshal(this.finishtime);
/*  109 */     _os_.marshal(this.punishtime);
/*  110 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*  117 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  119 */       int _v_ = 0;
/*  120 */       _v_ = _os_.unmarshal_int();
/*  121 */       this.questionlist.add(Integer.valueOf(_v_));
/*      */     }
/*  123 */     this.state = _os_.unmarshal_int();
/*  124 */     this.rightnum = _os_.unmarshal_int();
/*  125 */     this.answernum = _os_.unmarshal_int();
/*  126 */     this.ispasshuishi = _os_.unmarshal_boolean();
/*  127 */     this.starttime = _os_.unmarshal_long();
/*  128 */     this.finishtime = _os_.unmarshal_long();
/*  129 */     this.punishtime = _os_.unmarshal_int();
/*  130 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  136 */     _xdb_verify_unsafe_();
/*  137 */     int _size_ = 0;
/*  138 */     for (Integer _v_ : this.questionlist)
/*      */     {
/*  140 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */     }
/*  142 */     _size_ += CodedOutputStream.computeInt32Size(3, this.state);
/*  143 */     _size_ += CodedOutputStream.computeInt32Size(4, this.rightnum);
/*  144 */     _size_ += CodedOutputStream.computeInt32Size(5, this.answernum);
/*  145 */     _size_ += CodedOutputStream.computeBoolSize(6, this.ispasshuishi);
/*  146 */     _size_ += CodedOutputStream.computeInt64Size(7, this.starttime);
/*  147 */     _size_ += CodedOutputStream.computeInt64Size(8, this.finishtime);
/*  148 */     _size_ += CodedOutputStream.computeInt32Size(9, this.punishtime);
/*  149 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  155 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  158 */       for (Integer _v_ : this.questionlist)
/*      */       {
/*  160 */         _output_.writeInt32(2, _v_.intValue());
/*      */       }
/*  162 */       _output_.writeInt32(3, this.state);
/*  163 */       _output_.writeInt32(4, this.rightnum);
/*  164 */       _output_.writeInt32(5, this.answernum);
/*  165 */       _output_.writeBool(6, this.ispasshuishi);
/*  166 */       _output_.writeInt64(7, this.starttime);
/*  167 */       _output_.writeInt64(8, this.finishtime);
/*  168 */       _output_.writeInt32(9, this.punishtime);
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
/*      */         case 16: 
/*  196 */           int _v_ = 0;
/*  197 */           _v_ = _input_.readInt32();
/*  198 */           this.questionlist.add(Integer.valueOf(_v_));
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  203 */           this.state = _input_.readInt32();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  208 */           this.rightnum = _input_.readInt32();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  213 */           this.answernum = _input_.readInt32();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  218 */           this.ispasshuishi = _input_.readBool();
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  223 */           this.starttime = _input_.readInt64();
/*  224 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  228 */           this.finishtime = _input_.readInt64();
/*  229 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  233 */           this.punishtime = _input_.readInt32();
/*  234 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  238 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  240 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  249 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  253 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  255 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.KeJuInfo copy()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return new KeJuInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.KeJuInfo toData()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.KeJuInfo toBean()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new KeJuInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.KeJuInfo toDataIf()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.KeJuInfo toBeanIf()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getQuestionlist()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return Logs.logList(new LogKey(this, "questionlist"), this.questionlist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getQuestionlistAsData()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*      */     
/*  311 */     KeJuInfo _o_ = this;
/*  312 */     List<Integer> questionlist = new ArrayList();
/*  313 */     questionlist.addAll(_o_.questionlist);
/*  314 */     return questionlist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRightnum()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return this.rightnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAnswernum()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return this.answernum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIspasshuishi()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     return this.ispasshuishi;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttime()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     return this.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getFinishtime()
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*  362 */     return this.finishtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPunishtime()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return this.punishtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  382 */         new LogInt(this, KeJuInfo.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  386 */             KeJuInfo.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  390 */     });
/*  391 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRightnum(int _v_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     Logs.logIf(new LogKey(this, "rightnum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  403 */         new LogInt(this, KeJuInfo.this.rightnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  407 */             KeJuInfo.this.rightnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  411 */     });
/*  412 */     this.rightnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAnswernum(int _v_)
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     Logs.logIf(new LogKey(this, "answernum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  424 */         new LogInt(this, KeJuInfo.this.answernum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  428 */             KeJuInfo.this.answernum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  432 */     });
/*  433 */     this.answernum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIspasshuishi(boolean _v_)
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     Logs.logIf(new LogKey(this, "ispasshuishi")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  445 */         new xdb.logs.LogObject(this, Boolean.valueOf(KeJuInfo.this.ispasshuishi))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  449 */             KeJuInfo.this.ispasshuishi = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  453 */     });
/*  454 */     this.ispasshuishi = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttime(long _v_)
/*      */   {
/*  461 */     _xdb_verify_unsafe_();
/*  462 */     Logs.logIf(new LogKey(this, "starttime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  466 */         new xdb.logs.LogLong(this, KeJuInfo.this.starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  470 */             KeJuInfo.this.starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  474 */     });
/*  475 */     this.starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFinishtime(long _v_)
/*      */   {
/*  482 */     _xdb_verify_unsafe_();
/*  483 */     Logs.logIf(new LogKey(this, "finishtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  487 */         new xdb.logs.LogLong(this, KeJuInfo.this.finishtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  491 */             KeJuInfo.this.finishtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  495 */     });
/*  496 */     this.finishtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPunishtime(int _v_)
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     Logs.logIf(new LogKey(this, "punishtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  508 */         new LogInt(this, KeJuInfo.this.punishtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  512 */             KeJuInfo.this.punishtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  516 */     });
/*  517 */     this.punishtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  523 */     _xdb_verify_unsafe_();
/*  524 */     KeJuInfo _o_ = null;
/*  525 */     if ((_o1_ instanceof KeJuInfo)) { _o_ = (KeJuInfo)_o1_;
/*  526 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  527 */       return false;
/*  528 */     if (!this.questionlist.equals(_o_.questionlist)) return false;
/*  529 */     if (this.state != _o_.state) return false;
/*  530 */     if (this.rightnum != _o_.rightnum) return false;
/*  531 */     if (this.answernum != _o_.answernum) return false;
/*  532 */     if (this.ispasshuishi != _o_.ispasshuishi) return false;
/*  533 */     if (this.starttime != _o_.starttime) return false;
/*  534 */     if (this.finishtime != _o_.finishtime) return false;
/*  535 */     if (this.punishtime != _o_.punishtime) return false;
/*  536 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  542 */     _xdb_verify_unsafe_();
/*  543 */     int _h_ = 0;
/*  544 */     _h_ += this.questionlist.hashCode();
/*  545 */     _h_ += this.state;
/*  546 */     _h_ += this.rightnum;
/*  547 */     _h_ += this.answernum;
/*  548 */     _h_ += (this.ispasshuishi ? 1231 : 1237);
/*  549 */     _h_ = (int)(_h_ + this.starttime);
/*  550 */     _h_ = (int)(_h_ + this.finishtime);
/*  551 */     _h_ += this.punishtime;
/*  552 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  558 */     _xdb_verify_unsafe_();
/*  559 */     StringBuilder _sb_ = new StringBuilder();
/*  560 */     _sb_.append("(");
/*  561 */     _sb_.append(this.questionlist);
/*  562 */     _sb_.append(",");
/*  563 */     _sb_.append(this.state);
/*  564 */     _sb_.append(",");
/*  565 */     _sb_.append(this.rightnum);
/*  566 */     _sb_.append(",");
/*  567 */     _sb_.append(this.answernum);
/*  568 */     _sb_.append(",");
/*  569 */     _sb_.append(this.ispasshuishi);
/*  570 */     _sb_.append(",");
/*  571 */     _sb_.append(this.starttime);
/*  572 */     _sb_.append(",");
/*  573 */     _sb_.append(this.finishtime);
/*  574 */     _sb_.append(",");
/*  575 */     _sb_.append(this.punishtime);
/*  576 */     _sb_.append(")");
/*  577 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  583 */     ListenableBean lb = new ListenableBean();
/*  584 */     lb.add(new ListenableChanged().setVarName("questionlist"));
/*  585 */     lb.add(new ListenableChanged().setVarName("state"));
/*  586 */     lb.add(new ListenableChanged().setVarName("rightnum"));
/*  587 */     lb.add(new ListenableChanged().setVarName("answernum"));
/*  588 */     lb.add(new ListenableChanged().setVarName("ispasshuishi"));
/*  589 */     lb.add(new ListenableChanged().setVarName("starttime"));
/*  590 */     lb.add(new ListenableChanged().setVarName("finishtime"));
/*  591 */     lb.add(new ListenableChanged().setVarName("punishtime"));
/*  592 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.KeJuInfo {
/*      */     private Const() {}
/*      */     
/*      */     KeJuInfo nThis() {
/*  599 */       return KeJuInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  605 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KeJuInfo copy()
/*      */     {
/*  611 */       return KeJuInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KeJuInfo toData()
/*      */     {
/*  617 */       return KeJuInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.KeJuInfo toBean()
/*      */     {
/*  622 */       return KeJuInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KeJuInfo toDataIf()
/*      */     {
/*  628 */       return KeJuInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.KeJuInfo toBeanIf()
/*      */     {
/*  633 */       return KeJuInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getQuestionlist()
/*      */     {
/*  640 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  641 */       return xdb.Consts.constList(KeJuInfo.this.questionlist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getQuestionlistAsData()
/*      */     {
/*  647 */       KeJuInfo.this._xdb_verify_unsafe_();
/*      */       
/*  649 */       KeJuInfo _o_ = KeJuInfo.this;
/*  650 */       List<Integer> questionlist = new ArrayList();
/*  651 */       questionlist.addAll(_o_.questionlist);
/*  652 */       return questionlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/*  659 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  660 */       return KeJuInfo.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRightnum()
/*      */     {
/*  667 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  668 */       return KeJuInfo.this.rightnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAnswernum()
/*      */     {
/*  675 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  676 */       return KeJuInfo.this.answernum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIspasshuishi()
/*      */     {
/*  683 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  684 */       return KeJuInfo.this.ispasshuishi;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/*  691 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  692 */       return KeJuInfo.this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFinishtime()
/*      */     {
/*  699 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  700 */       return KeJuInfo.this.finishtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPunishtime()
/*      */     {
/*  707 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  708 */       return KeJuInfo.this.punishtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/*  715 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  716 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRightnum(int _v_)
/*      */     {
/*  723 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  724 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnswernum(int _v_)
/*      */     {
/*  731 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  732 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIspasshuishi(boolean _v_)
/*      */     {
/*  739 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  740 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/*  747 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  748 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinishtime(long _v_)
/*      */     {
/*  755 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  756 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPunishtime(int _v_)
/*      */     {
/*  763 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  764 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  770 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  771 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  777 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  778 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  784 */       return KeJuInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  790 */       return KeJuInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  796 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  797 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  803 */       return KeJuInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  809 */       return KeJuInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  815 */       KeJuInfo.this._xdb_verify_unsafe_();
/*  816 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  822 */       return KeJuInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  828 */       return KeJuInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  834 */       return KeJuInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  840 */       return KeJuInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  846 */       return KeJuInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  852 */       return KeJuInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  858 */       return KeJuInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.KeJuInfo
/*      */   {
/*      */     private ArrayList<Integer> questionlist;
/*      */     
/*      */     private int state;
/*      */     
/*      */     private int rightnum;
/*      */     
/*      */     private int answernum;
/*      */     
/*      */     private boolean ispasshuishi;
/*      */     
/*      */     private long starttime;
/*      */     
/*      */     private long finishtime;
/*      */     
/*      */     private int punishtime;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  884 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  889 */       this.questionlist = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.KeJuInfo _o1_)
/*      */     {
/*  894 */       if ((_o1_ instanceof KeJuInfo)) { assign((KeJuInfo)_o1_);
/*  895 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  896 */       } else if ((_o1_ instanceof KeJuInfo.Const)) assign(((KeJuInfo.Const)_o1_).nThis()); else {
/*  897 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(KeJuInfo _o_) {
/*  902 */       this.questionlist = new ArrayList();
/*  903 */       this.questionlist.addAll(_o_.questionlist);
/*  904 */       this.state = _o_.state;
/*  905 */       this.rightnum = _o_.rightnum;
/*  906 */       this.answernum = _o_.answernum;
/*  907 */       this.ispasshuishi = _o_.ispasshuishi;
/*  908 */       this.starttime = _o_.starttime;
/*  909 */       this.finishtime = _o_.finishtime;
/*  910 */       this.punishtime = _o_.punishtime;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  915 */       this.questionlist = new ArrayList();
/*  916 */       this.questionlist.addAll(_o_.questionlist);
/*  917 */       this.state = _o_.state;
/*  918 */       this.rightnum = _o_.rightnum;
/*  919 */       this.answernum = _o_.answernum;
/*  920 */       this.ispasshuishi = _o_.ispasshuishi;
/*  921 */       this.starttime = _o_.starttime;
/*  922 */       this.finishtime = _o_.finishtime;
/*  923 */       this.punishtime = _o_.punishtime;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  929 */       _os_.compact_uint32(this.questionlist.size());
/*  930 */       for (Integer _v_ : this.questionlist)
/*      */       {
/*  932 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  934 */       _os_.marshal(this.state);
/*  935 */       _os_.marshal(this.rightnum);
/*  936 */       _os_.marshal(this.answernum);
/*  937 */       _os_.marshal(this.ispasshuishi);
/*  938 */       _os_.marshal(this.starttime);
/*  939 */       _os_.marshal(this.finishtime);
/*  940 */       _os_.marshal(this.punishtime);
/*  941 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  947 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  949 */         int _v_ = 0;
/*  950 */         _v_ = _os_.unmarshal_int();
/*  951 */         this.questionlist.add(Integer.valueOf(_v_));
/*      */       }
/*  953 */       this.state = _os_.unmarshal_int();
/*  954 */       this.rightnum = _os_.unmarshal_int();
/*  955 */       this.answernum = _os_.unmarshal_int();
/*  956 */       this.ispasshuishi = _os_.unmarshal_boolean();
/*  957 */       this.starttime = _os_.unmarshal_long();
/*  958 */       this.finishtime = _os_.unmarshal_long();
/*  959 */       this.punishtime = _os_.unmarshal_int();
/*  960 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  966 */       int _size_ = 0;
/*  967 */       for (Integer _v_ : this.questionlist)
/*      */       {
/*  969 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */       }
/*  971 */       _size_ += CodedOutputStream.computeInt32Size(3, this.state);
/*  972 */       _size_ += CodedOutputStream.computeInt32Size(4, this.rightnum);
/*  973 */       _size_ += CodedOutputStream.computeInt32Size(5, this.answernum);
/*  974 */       _size_ += CodedOutputStream.computeBoolSize(6, this.ispasshuishi);
/*  975 */       _size_ += CodedOutputStream.computeInt64Size(7, this.starttime);
/*  976 */       _size_ += CodedOutputStream.computeInt64Size(8, this.finishtime);
/*  977 */       _size_ += CodedOutputStream.computeInt32Size(9, this.punishtime);
/*  978 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  986 */         for (Integer _v_ : this.questionlist)
/*      */         {
/*  988 */           _output_.writeInt32(2, _v_.intValue());
/*      */         }
/*  990 */         _output_.writeInt32(3, this.state);
/*  991 */         _output_.writeInt32(4, this.rightnum);
/*  992 */         _output_.writeInt32(5, this.answernum);
/*  993 */         _output_.writeBool(6, this.ispasshuishi);
/*  994 */         _output_.writeInt64(7, this.starttime);
/*  995 */         _output_.writeInt64(8, this.finishtime);
/*  996 */         _output_.writeInt32(9, this.punishtime);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1000 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1002 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1010 */         boolean done = false;
/* 1011 */         while (!done)
/*      */         {
/* 1013 */           int tag = _input_.readTag();
/* 1014 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1018 */             done = true;
/* 1019 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1023 */             int _v_ = 0;
/* 1024 */             _v_ = _input_.readInt32();
/* 1025 */             this.questionlist.add(Integer.valueOf(_v_));
/* 1026 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1030 */             this.state = _input_.readInt32();
/* 1031 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1035 */             this.rightnum = _input_.readInt32();
/* 1036 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1040 */             this.answernum = _input_.readInt32();
/* 1041 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1045 */             this.ispasshuishi = _input_.readBool();
/* 1046 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1050 */             this.starttime = _input_.readInt64();
/* 1051 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1055 */             this.finishtime = _input_.readInt64();
/* 1056 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1060 */             this.punishtime = _input_.readInt32();
/* 1061 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1065 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1067 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1076 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1080 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1082 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KeJuInfo copy()
/*      */     {
/* 1088 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KeJuInfo toData()
/*      */     {
/* 1094 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.KeJuInfo toBean()
/*      */     {
/* 1099 */       return new KeJuInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KeJuInfo toDataIf()
/*      */     {
/* 1105 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.KeJuInfo toBeanIf()
/*      */     {
/* 1110 */       return new KeJuInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1116 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1120 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1124 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1128 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1132 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1136 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1140 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getQuestionlist()
/*      */     {
/* 1147 */       return this.questionlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getQuestionlistAsData()
/*      */     {
/* 1154 */       return this.questionlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1161 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRightnum()
/*      */     {
/* 1168 */       return this.rightnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAnswernum()
/*      */     {
/* 1175 */       return this.answernum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIspasshuishi()
/*      */     {
/* 1182 */       return this.ispasshuishi;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 1189 */       return this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFinishtime()
/*      */     {
/* 1196 */       return this.finishtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPunishtime()
/*      */     {
/* 1203 */       return this.punishtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1210 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRightnum(int _v_)
/*      */     {
/* 1217 */       this.rightnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnswernum(int _v_)
/*      */     {
/* 1224 */       this.answernum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIspasshuishi(boolean _v_)
/*      */     {
/* 1231 */       this.ispasshuishi = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 1238 */       this.starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinishtime(long _v_)
/*      */     {
/* 1245 */       this.finishtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPunishtime(int _v_)
/*      */     {
/* 1252 */       this.punishtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1258 */       if (!(_o1_ instanceof Data)) return false;
/* 1259 */       Data _o_ = (Data)_o1_;
/* 1260 */       if (!this.questionlist.equals(_o_.questionlist)) return false;
/* 1261 */       if (this.state != _o_.state) return false;
/* 1262 */       if (this.rightnum != _o_.rightnum) return false;
/* 1263 */       if (this.answernum != _o_.answernum) return false;
/* 1264 */       if (this.ispasshuishi != _o_.ispasshuishi) return false;
/* 1265 */       if (this.starttime != _o_.starttime) return false;
/* 1266 */       if (this.finishtime != _o_.finishtime) return false;
/* 1267 */       if (this.punishtime != _o_.punishtime) return false;
/* 1268 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1274 */       int _h_ = 0;
/* 1275 */       _h_ += this.questionlist.hashCode();
/* 1276 */       _h_ += this.state;
/* 1277 */       _h_ += this.rightnum;
/* 1278 */       _h_ += this.answernum;
/* 1279 */       _h_ += (this.ispasshuishi ? 1231 : 1237);
/* 1280 */       _h_ = (int)(_h_ + this.starttime);
/* 1281 */       _h_ = (int)(_h_ + this.finishtime);
/* 1282 */       _h_ += this.punishtime;
/* 1283 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1289 */       StringBuilder _sb_ = new StringBuilder();
/* 1290 */       _sb_.append("(");
/* 1291 */       _sb_.append(this.questionlist);
/* 1292 */       _sb_.append(",");
/* 1293 */       _sb_.append(this.state);
/* 1294 */       _sb_.append(",");
/* 1295 */       _sb_.append(this.rightnum);
/* 1296 */       _sb_.append(",");
/* 1297 */       _sb_.append(this.answernum);
/* 1298 */       _sb_.append(",");
/* 1299 */       _sb_.append(this.ispasshuishi);
/* 1300 */       _sb_.append(",");
/* 1301 */       _sb_.append(this.starttime);
/* 1302 */       _sb_.append(",");
/* 1303 */       _sb_.append(this.finishtime);
/* 1304 */       _sb_.append(",");
/* 1305 */       _sb_.append(this.punishtime);
/* 1306 */       _sb_.append(")");
/* 1307 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\KeJuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */