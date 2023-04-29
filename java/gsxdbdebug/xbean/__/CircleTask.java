/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class CircleTask extends XBean implements xbean.CircleTask
/*     */ {
/*     */   private long legendendtime;
/*     */   private int renxingcounter;
/*     */   private int taskid;
/*     */   private int factioncontribution;
/*     */   private long factioncontributionupdatetime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.legendendtime = 0L;
/*  27 */     this.renxingcounter = 0;
/*  28 */     this.taskid = 0;
/*  29 */     this.factioncontribution = 0;
/*  30 */     this.factioncontributionupdatetime = 0L;
/*     */   }
/*     */   
/*     */   CircleTask(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public CircleTask()
/*     */   {
/*  40 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CircleTask(CircleTask _o_)
/*     */   {
/*  45 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CircleTask(xbean.CircleTask _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  50 */     super(_xp_, _vn_);
/*  51 */     if ((_o1_ instanceof CircleTask)) { assign((CircleTask)_o1_);
/*  52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  54 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CircleTask _o_) {
/*  59 */     _o_._xdb_verify_unsafe_();
/*  60 */     this.legendendtime = _o_.legendendtime;
/*  61 */     this.renxingcounter = _o_.renxingcounter;
/*  62 */     this.taskid = _o_.taskid;
/*  63 */     this.factioncontribution = _o_.factioncontribution;
/*  64 */     this.factioncontributionupdatetime = _o_.factioncontributionupdatetime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.legendendtime = _o_.legendendtime;
/*  70 */     this.renxingcounter = _o_.renxingcounter;
/*  71 */     this.taskid = _o_.taskid;
/*  72 */     this.factioncontribution = _o_.factioncontribution;
/*  73 */     this.factioncontributionupdatetime = _o_.factioncontributionupdatetime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.legendendtime);
/*  81 */     _os_.marshal(this.renxingcounter);
/*  82 */     _os_.marshal(this.taskid);
/*  83 */     _os_.marshal(this.factioncontribution);
/*  84 */     _os_.marshal(this.factioncontributionupdatetime);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     this.legendendtime = _os_.unmarshal_long();
/*  93 */     this.renxingcounter = _os_.unmarshal_int();
/*  94 */     this.taskid = _os_.unmarshal_int();
/*  95 */     this.factioncontribution = _os_.unmarshal_int();
/*  96 */     this.factioncontributionupdatetime = _os_.unmarshal_long();
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     _size_ += CodedOutputStream.computeInt64Size(1, this.legendendtime);
/* 106 */     _size_ += CodedOutputStream.computeInt32Size(2, this.renxingcounter);
/* 107 */     _size_ += CodedOutputStream.computeInt32Size(3, this.taskid);
/* 108 */     _size_ += CodedOutputStream.computeInt32Size(4, this.factioncontribution);
/* 109 */     _size_ += CodedOutputStream.computeInt64Size(5, this.factioncontributionupdatetime);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt64(1, this.legendendtime);
/* 120 */       _output_.writeInt32(2, this.renxingcounter);
/* 121 */       _output_.writeInt32(3, this.taskid);
/* 122 */       _output_.writeInt32(4, this.factioncontribution);
/* 123 */       _output_.writeInt64(5, this.factioncontributionupdatetime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 127 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 129 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       boolean done = false;
/* 139 */       while (!done)
/*     */       {
/* 141 */         int tag = _input_.readTag();
/* 142 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 146 */           done = true;
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 151 */           this.legendendtime = _input_.readInt64();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           this.renxingcounter = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 161 */           this.taskid = _input_.readInt32();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 166 */           this.factioncontribution = _input_.readInt32();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 171 */           this.factioncontributionupdatetime = _input_.readInt64();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CircleTask copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new CircleTask(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CircleTask toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CircleTask toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new CircleTask(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CircleTask toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CircleTask toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLegendendtime()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.legendendtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRenxingcounter()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return this.renxingcounter;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTaskid()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     return this.taskid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getFactioncontribution()
/*     */   {
/* 264 */     _xdb_verify_unsafe_();
/* 265 */     return this.factioncontribution;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getFactioncontributionupdatetime()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return this.factioncontributionupdatetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLegendendtime(long _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "legendendtime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 285 */         new xdb.logs.LogLong(this, CircleTask.this.legendendtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             CircleTask.this.legendendtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.legendendtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRenxingcounter(int _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "renxingcounter")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 306 */         new LogInt(this, CircleTask.this.renxingcounter)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             CircleTask.this.renxingcounter = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.renxingcounter = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTaskid(int _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new LogKey(this, "taskid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 327 */         new LogInt(this, CircleTask.this.taskid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             CircleTask.this.taskid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.taskid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFactioncontribution(int _v_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     xdb.Logs.logIf(new LogKey(this, "factioncontribution")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 348 */         new LogInt(this, CircleTask.this.factioncontribution)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 352 */             CircleTask.this.factioncontribution = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 356 */     });
/* 357 */     this.factioncontribution = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFactioncontributionupdatetime(long _v_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     xdb.Logs.logIf(new LogKey(this, "factioncontributionupdatetime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 369 */         new xdb.logs.LogLong(this, CircleTask.this.factioncontributionupdatetime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 373 */             CircleTask.this.factioncontributionupdatetime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 377 */     });
/* 378 */     this.factioncontributionupdatetime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 384 */     _xdb_verify_unsafe_();
/* 385 */     CircleTask _o_ = null;
/* 386 */     if ((_o1_ instanceof CircleTask)) { _o_ = (CircleTask)_o1_;
/* 387 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 388 */       return false;
/* 389 */     if (this.legendendtime != _o_.legendendtime) return false;
/* 390 */     if (this.renxingcounter != _o_.renxingcounter) return false;
/* 391 */     if (this.taskid != _o_.taskid) return false;
/* 392 */     if (this.factioncontribution != _o_.factioncontribution) return false;
/* 393 */     if (this.factioncontributionupdatetime != _o_.factioncontributionupdatetime) return false;
/* 394 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 400 */     _xdb_verify_unsafe_();
/* 401 */     int _h_ = 0;
/* 402 */     _h_ = (int)(_h_ + this.legendendtime);
/* 403 */     _h_ += this.renxingcounter;
/* 404 */     _h_ += this.taskid;
/* 405 */     _h_ += this.factioncontribution;
/* 406 */     _h_ = (int)(_h_ + this.factioncontributionupdatetime);
/* 407 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 413 */     _xdb_verify_unsafe_();
/* 414 */     StringBuilder _sb_ = new StringBuilder();
/* 415 */     _sb_.append("(");
/* 416 */     _sb_.append(this.legendendtime);
/* 417 */     _sb_.append(",");
/* 418 */     _sb_.append(this.renxingcounter);
/* 419 */     _sb_.append(",");
/* 420 */     _sb_.append(this.taskid);
/* 421 */     _sb_.append(",");
/* 422 */     _sb_.append(this.factioncontribution);
/* 423 */     _sb_.append(",");
/* 424 */     _sb_.append(this.factioncontributionupdatetime);
/* 425 */     _sb_.append(")");
/* 426 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 432 */     ListenableBean lb = new ListenableBean();
/* 433 */     lb.add(new ListenableChanged().setVarName("legendendtime"));
/* 434 */     lb.add(new ListenableChanged().setVarName("renxingcounter"));
/* 435 */     lb.add(new ListenableChanged().setVarName("taskid"));
/* 436 */     lb.add(new ListenableChanged().setVarName("factioncontribution"));
/* 437 */     lb.add(new ListenableChanged().setVarName("factioncontributionupdatetime"));
/* 438 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CircleTask {
/*     */     private Const() {}
/*     */     
/*     */     CircleTask nThis() {
/* 445 */       return CircleTask.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CircleTask copy()
/*     */     {
/* 457 */       return CircleTask.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CircleTask toData()
/*     */     {
/* 463 */       return CircleTask.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CircleTask toBean()
/*     */     {
/* 468 */       return CircleTask.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CircleTask toDataIf()
/*     */     {
/* 474 */       return CircleTask.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CircleTask toBeanIf()
/*     */     {
/* 479 */       return CircleTask.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLegendendtime()
/*     */     {
/* 486 */       CircleTask.this._xdb_verify_unsafe_();
/* 487 */       return CircleTask.this.legendendtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRenxingcounter()
/*     */     {
/* 494 */       CircleTask.this._xdb_verify_unsafe_();
/* 495 */       return CircleTask.this.renxingcounter;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTaskid()
/*     */     {
/* 502 */       CircleTask.this._xdb_verify_unsafe_();
/* 503 */       return CircleTask.this.taskid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFactioncontribution()
/*     */     {
/* 510 */       CircleTask.this._xdb_verify_unsafe_();
/* 511 */       return CircleTask.this.factioncontribution;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFactioncontributionupdatetime()
/*     */     {
/* 518 */       CircleTask.this._xdb_verify_unsafe_();
/* 519 */       return CircleTask.this.factioncontributionupdatetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLegendendtime(long _v_)
/*     */     {
/* 526 */       CircleTask.this._xdb_verify_unsafe_();
/* 527 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRenxingcounter(int _v_)
/*     */     {
/* 534 */       CircleTask.this._xdb_verify_unsafe_();
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTaskid(int _v_)
/*     */     {
/* 542 */       CircleTask.this._xdb_verify_unsafe_();
/* 543 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFactioncontribution(int _v_)
/*     */     {
/* 550 */       CircleTask.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFactioncontributionupdatetime(long _v_)
/*     */     {
/* 558 */       CircleTask.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 565 */       CircleTask.this._xdb_verify_unsafe_();
/* 566 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 572 */       CircleTask.this._xdb_verify_unsafe_();
/* 573 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 579 */       return CircleTask.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 585 */       return CircleTask.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 591 */       CircleTask.this._xdb_verify_unsafe_();
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 598 */       return CircleTask.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 604 */       return CircleTask.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 610 */       CircleTask.this._xdb_verify_unsafe_();
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 617 */       return CircleTask.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       return CircleTask.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 629 */       return CircleTask.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 635 */       return CircleTask.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 641 */       return CircleTask.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 647 */       return CircleTask.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 653 */       return CircleTask.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CircleTask
/*     */   {
/*     */     private long legendendtime;
/*     */     
/*     */     private int renxingcounter;
/*     */     
/*     */     private int taskid;
/*     */     
/*     */     private int factioncontribution;
/*     */     
/*     */     private long factioncontributionupdatetime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 673 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.CircleTask _o1_)
/*     */     {
/* 682 */       if ((_o1_ instanceof CircleTask)) { assign((CircleTask)_o1_);
/* 683 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 684 */       } else if ((_o1_ instanceof CircleTask.Const)) assign(((CircleTask.Const)_o1_).nThis()); else {
/* 685 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CircleTask _o_) {
/* 690 */       this.legendendtime = _o_.legendendtime;
/* 691 */       this.renxingcounter = _o_.renxingcounter;
/* 692 */       this.taskid = _o_.taskid;
/* 693 */       this.factioncontribution = _o_.factioncontribution;
/* 694 */       this.factioncontributionupdatetime = _o_.factioncontributionupdatetime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 699 */       this.legendendtime = _o_.legendendtime;
/* 700 */       this.renxingcounter = _o_.renxingcounter;
/* 701 */       this.taskid = _o_.taskid;
/* 702 */       this.factioncontribution = _o_.factioncontribution;
/* 703 */       this.factioncontributionupdatetime = _o_.factioncontributionupdatetime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 709 */       _os_.marshal(this.legendendtime);
/* 710 */       _os_.marshal(this.renxingcounter);
/* 711 */       _os_.marshal(this.taskid);
/* 712 */       _os_.marshal(this.factioncontribution);
/* 713 */       _os_.marshal(this.factioncontributionupdatetime);
/* 714 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 720 */       this.legendendtime = _os_.unmarshal_long();
/* 721 */       this.renxingcounter = _os_.unmarshal_int();
/* 722 */       this.taskid = _os_.unmarshal_int();
/* 723 */       this.factioncontribution = _os_.unmarshal_int();
/* 724 */       this.factioncontributionupdatetime = _os_.unmarshal_long();
/* 725 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 731 */       int _size_ = 0;
/* 732 */       _size_ += CodedOutputStream.computeInt64Size(1, this.legendendtime);
/* 733 */       _size_ += CodedOutputStream.computeInt32Size(2, this.renxingcounter);
/* 734 */       _size_ += CodedOutputStream.computeInt32Size(3, this.taskid);
/* 735 */       _size_ += CodedOutputStream.computeInt32Size(4, this.factioncontribution);
/* 736 */       _size_ += CodedOutputStream.computeInt64Size(5, this.factioncontributionupdatetime);
/* 737 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 745 */         _output_.writeInt64(1, this.legendendtime);
/* 746 */         _output_.writeInt32(2, this.renxingcounter);
/* 747 */         _output_.writeInt32(3, this.taskid);
/* 748 */         _output_.writeInt32(4, this.factioncontribution);
/* 749 */         _output_.writeInt64(5, this.factioncontributionupdatetime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 753 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 755 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 763 */         boolean done = false;
/* 764 */         while (!done)
/*     */         {
/* 766 */           int tag = _input_.readTag();
/* 767 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 771 */             done = true;
/* 772 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 776 */             this.legendendtime = _input_.readInt64();
/* 777 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 781 */             this.renxingcounter = _input_.readInt32();
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 786 */             this.taskid = _input_.readInt32();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 791 */             this.factioncontribution = _input_.readInt32();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 796 */             this.factioncontributionupdatetime = _input_.readInt64();
/* 797 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 801 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 803 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 812 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 816 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 818 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CircleTask copy()
/*     */     {
/* 824 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CircleTask toData()
/*     */     {
/* 830 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CircleTask toBean()
/*     */     {
/* 835 */       return new CircleTask(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CircleTask toDataIf()
/*     */     {
/* 841 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CircleTask toBeanIf()
/*     */     {
/* 846 */       return new CircleTask(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 852 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 872 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 876 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLegendendtime()
/*     */     {
/* 883 */       return this.legendendtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRenxingcounter()
/*     */     {
/* 890 */       return this.renxingcounter;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTaskid()
/*     */     {
/* 897 */       return this.taskid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFactioncontribution()
/*     */     {
/* 904 */       return this.factioncontribution;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFactioncontributionupdatetime()
/*     */     {
/* 911 */       return this.factioncontributionupdatetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLegendendtime(long _v_)
/*     */     {
/* 918 */       this.legendendtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRenxingcounter(int _v_)
/*     */     {
/* 925 */       this.renxingcounter = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTaskid(int _v_)
/*     */     {
/* 932 */       this.taskid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFactioncontribution(int _v_)
/*     */     {
/* 939 */       this.factioncontribution = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFactioncontributionupdatetime(long _v_)
/*     */     {
/* 946 */       this.factioncontributionupdatetime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 952 */       if (!(_o1_ instanceof Data)) return false;
/* 953 */       Data _o_ = (Data)_o1_;
/* 954 */       if (this.legendendtime != _o_.legendendtime) return false;
/* 955 */       if (this.renxingcounter != _o_.renxingcounter) return false;
/* 956 */       if (this.taskid != _o_.taskid) return false;
/* 957 */       if (this.factioncontribution != _o_.factioncontribution) return false;
/* 958 */       if (this.factioncontributionupdatetime != _o_.factioncontributionupdatetime) return false;
/* 959 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 965 */       int _h_ = 0;
/* 966 */       _h_ = (int)(_h_ + this.legendendtime);
/* 967 */       _h_ += this.renxingcounter;
/* 968 */       _h_ += this.taskid;
/* 969 */       _h_ += this.factioncontribution;
/* 970 */       _h_ = (int)(_h_ + this.factioncontributionupdatetime);
/* 971 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 977 */       StringBuilder _sb_ = new StringBuilder();
/* 978 */       _sb_.append("(");
/* 979 */       _sb_.append(this.legendendtime);
/* 980 */       _sb_.append(",");
/* 981 */       _sb_.append(this.renxingcounter);
/* 982 */       _sb_.append(",");
/* 983 */       _sb_.append(this.taskid);
/* 984 */       _sb_.append(",");
/* 985 */       _sb_.append(this.factioncontribution);
/* 986 */       _sb_.append(",");
/* 987 */       _sb_.append(this.factioncontributionupdatetime);
/* 988 */       _sb_.append(")");
/* 989 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CircleTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */