/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class SchoolChallenge extends XBean implements xbean.SchoolChallenge
/*     */ {
/*     */   private int currentring;
/*     */   private int awardcirclecount;
/*     */   private ArrayList<Integer> taskids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.currentring = 0;
/*  23 */     this.awardcirclecount = 0;
/*  24 */     this.taskids.clear();
/*     */   }
/*     */   
/*     */   SchoolChallenge(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.currentring = 0;
/*  31 */     this.awardcirclecount = 0;
/*  32 */     this.taskids = new ArrayList();
/*     */   }
/*     */   
/*     */   public SchoolChallenge()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SchoolChallenge(SchoolChallenge _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SchoolChallenge(xbean.SchoolChallenge _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof SchoolChallenge)) { assign((SchoolChallenge)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SchoolChallenge _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.currentring = _o_.currentring;
/*  58 */     this.awardcirclecount = _o_.awardcirclecount;
/*  59 */     this.taskids = new ArrayList();
/*  60 */     this.taskids.addAll(_o_.taskids);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.currentring = _o_.currentring;
/*  66 */     this.awardcirclecount = _o_.awardcirclecount;
/*  67 */     this.taskids = new ArrayList();
/*  68 */     this.taskids.addAll(_o_.taskids);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.currentring);
/*  76 */     _os_.marshal(this.awardcirclecount);
/*  77 */     _os_.compact_uint32(this.taskids.size());
/*  78 */     for (Integer _v_ : this.taskids)
/*     */     {
/*  80 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  88 */     _xdb_verify_unsafe_();
/*  89 */     this.currentring = _os_.unmarshal_int();
/*  90 */     this.awardcirclecount = _os_.unmarshal_int();
/*  91 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  93 */       int _v_ = 0;
/*  94 */       _v_ = _os_.unmarshal_int();
/*  95 */       this.taskids.add(Integer.valueOf(_v_));
/*     */     }
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     _size_ += CodedOutputStream.computeInt32Size(1, this.currentring);
/* 106 */     _size_ += CodedOutputStream.computeInt32Size(2, this.awardcirclecount);
/* 107 */     for (Integer _v_ : this.taskids)
/*     */     {
/* 109 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */     }
/* 111 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       _output_.writeInt32(1, this.currentring);
/* 121 */       _output_.writeInt32(2, this.awardcirclecount);
/* 122 */       for (Integer _v_ : this.taskids)
/*     */       {
/* 124 */         _output_.writeInt32(3, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 129 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 131 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 140 */       boolean done = false;
/* 141 */       while (!done)
/*     */       {
/* 143 */         int tag = _input_.readTag();
/* 144 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 148 */           done = true;
/* 149 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 153 */           this.currentring = _input_.readInt32();
/* 154 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 158 */           this.awardcirclecount = _input_.readInt32();
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 163 */           int _v_ = 0;
/* 164 */           _v_ = _input_.readInt32();
/* 165 */           this.taskids.add(Integer.valueOf(_v_));
/* 166 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 170 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 172 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 181 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 185 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 187 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SchoolChallenge copy()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new SchoolChallenge(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SchoolChallenge toData()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SchoolChallenge toBean()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new SchoolChallenge(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SchoolChallenge toDataIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SchoolChallenge toBeanIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCurrentring()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.currentring;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAwardcirclecount()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.awardcirclecount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getTaskids()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return xdb.Logs.logList(new LogKey(this, "taskids"), this.taskids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getTaskidsAsData()
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/*     */     
/* 259 */     SchoolChallenge _o_ = this;
/* 260 */     List<Integer> taskids = new ArrayList();
/* 261 */     taskids.addAll(_o_.taskids);
/* 262 */     return taskids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCurrentring(int _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new LogKey(this, "currentring")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogInt(this, SchoolChallenge.this.currentring)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             SchoolChallenge.this.currentring = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.currentring = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAwardcirclecount(int _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "awardcirclecount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogInt(this, SchoolChallenge.this.awardcirclecount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             SchoolChallenge.this.awardcirclecount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.awardcirclecount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/* 311 */     SchoolChallenge _o_ = null;
/* 312 */     if ((_o1_ instanceof SchoolChallenge)) { _o_ = (SchoolChallenge)_o1_;
/* 313 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 314 */       return false;
/* 315 */     if (this.currentring != _o_.currentring) return false;
/* 316 */     if (this.awardcirclecount != _o_.awardcirclecount) return false;
/* 317 */     if (!this.taskids.equals(_o_.taskids)) return false;
/* 318 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     int _h_ = 0;
/* 326 */     _h_ += this.currentring;
/* 327 */     _h_ += this.awardcirclecount;
/* 328 */     _h_ += this.taskids.hashCode();
/* 329 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 335 */     _xdb_verify_unsafe_();
/* 336 */     StringBuilder _sb_ = new StringBuilder();
/* 337 */     _sb_.append("(");
/* 338 */     _sb_.append(this.currentring);
/* 339 */     _sb_.append(",");
/* 340 */     _sb_.append(this.awardcirclecount);
/* 341 */     _sb_.append(",");
/* 342 */     _sb_.append(this.taskids);
/* 343 */     _sb_.append(")");
/* 344 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 350 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 351 */     lb.add(new ListenableChanged().setVarName("currentring"));
/* 352 */     lb.add(new ListenableChanged().setVarName("awardcirclecount"));
/* 353 */     lb.add(new ListenableChanged().setVarName("taskids"));
/* 354 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SchoolChallenge {
/*     */     private Const() {}
/*     */     
/*     */     SchoolChallenge nThis() {
/* 361 */       return SchoolChallenge.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SchoolChallenge copy()
/*     */     {
/* 373 */       return SchoolChallenge.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SchoolChallenge toData()
/*     */     {
/* 379 */       return SchoolChallenge.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SchoolChallenge toBean()
/*     */     {
/* 384 */       return SchoolChallenge.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SchoolChallenge toDataIf()
/*     */     {
/* 390 */       return SchoolChallenge.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SchoolChallenge toBeanIf()
/*     */     {
/* 395 */       return SchoolChallenge.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurrentring()
/*     */     {
/* 402 */       SchoolChallenge.this._xdb_verify_unsafe_();
/* 403 */       return SchoolChallenge.this.currentring;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAwardcirclecount()
/*     */     {
/* 410 */       SchoolChallenge.this._xdb_verify_unsafe_();
/* 411 */       return SchoolChallenge.this.awardcirclecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getTaskids()
/*     */     {
/* 418 */       SchoolChallenge.this._xdb_verify_unsafe_();
/* 419 */       return xdb.Consts.constList(SchoolChallenge.this.taskids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getTaskidsAsData()
/*     */     {
/* 425 */       SchoolChallenge.this._xdb_verify_unsafe_();
/*     */       
/* 427 */       SchoolChallenge _o_ = SchoolChallenge.this;
/* 428 */       List<Integer> taskids = new ArrayList();
/* 429 */       taskids.addAll(_o_.taskids);
/* 430 */       return taskids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurrentring(int _v_)
/*     */     {
/* 437 */       SchoolChallenge.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwardcirclecount(int _v_)
/*     */     {
/* 445 */       SchoolChallenge.this._xdb_verify_unsafe_();
/* 446 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 452 */       SchoolChallenge.this._xdb_verify_unsafe_();
/* 453 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 459 */       SchoolChallenge.this._xdb_verify_unsafe_();
/* 460 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 466 */       return SchoolChallenge.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 472 */       return SchoolChallenge.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 478 */       SchoolChallenge.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 485 */       return SchoolChallenge.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 491 */       return SchoolChallenge.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 497 */       SchoolChallenge.this._xdb_verify_unsafe_();
/* 498 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 504 */       return SchoolChallenge.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 510 */       return SchoolChallenge.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 516 */       return SchoolChallenge.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 522 */       return SchoolChallenge.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 528 */       return SchoolChallenge.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 534 */       return SchoolChallenge.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 540 */       return SchoolChallenge.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SchoolChallenge
/*     */   {
/*     */     private int currentring;
/*     */     
/*     */     private int awardcirclecount;
/*     */     
/*     */     private ArrayList<Integer> taskids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 561 */       this.currentring = 0;
/* 562 */       this.awardcirclecount = 0;
/* 563 */       this.taskids = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.SchoolChallenge _o1_)
/*     */     {
/* 568 */       if ((_o1_ instanceof SchoolChallenge)) { assign((SchoolChallenge)_o1_);
/* 569 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 570 */       } else if ((_o1_ instanceof SchoolChallenge.Const)) assign(((SchoolChallenge.Const)_o1_).nThis()); else {
/* 571 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SchoolChallenge _o_) {
/* 576 */       this.currentring = _o_.currentring;
/* 577 */       this.awardcirclecount = _o_.awardcirclecount;
/* 578 */       this.taskids = new ArrayList();
/* 579 */       this.taskids.addAll(_o_.taskids);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 584 */       this.currentring = _o_.currentring;
/* 585 */       this.awardcirclecount = _o_.awardcirclecount;
/* 586 */       this.taskids = new ArrayList();
/* 587 */       this.taskids.addAll(_o_.taskids);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 593 */       _os_.marshal(this.currentring);
/* 594 */       _os_.marshal(this.awardcirclecount);
/* 595 */       _os_.compact_uint32(this.taskids.size());
/* 596 */       for (Integer _v_ : this.taskids)
/*     */       {
/* 598 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 600 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 606 */       this.currentring = _os_.unmarshal_int();
/* 607 */       this.awardcirclecount = _os_.unmarshal_int();
/* 608 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 610 */         int _v_ = 0;
/* 611 */         _v_ = _os_.unmarshal_int();
/* 612 */         this.taskids.add(Integer.valueOf(_v_));
/*     */       }
/* 614 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 620 */       int _size_ = 0;
/* 621 */       _size_ += CodedOutputStream.computeInt32Size(1, this.currentring);
/* 622 */       _size_ += CodedOutputStream.computeInt32Size(2, this.awardcirclecount);
/* 623 */       for (Integer _v_ : this.taskids)
/*     */       {
/* 625 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */       }
/* 627 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 635 */         _output_.writeInt32(1, this.currentring);
/* 636 */         _output_.writeInt32(2, this.awardcirclecount);
/* 637 */         for (Integer _v_ : this.taskids)
/*     */         {
/* 639 */           _output_.writeInt32(3, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 644 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 646 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 654 */         boolean done = false;
/* 655 */         while (!done)
/*     */         {
/* 657 */           int tag = _input_.readTag();
/* 658 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 662 */             done = true;
/* 663 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 667 */             this.currentring = _input_.readInt32();
/* 668 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 672 */             this.awardcirclecount = _input_.readInt32();
/* 673 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 677 */             int _v_ = 0;
/* 678 */             _v_ = _input_.readInt32();
/* 679 */             this.taskids.add(Integer.valueOf(_v_));
/* 680 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 684 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 686 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 695 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 699 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 701 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SchoolChallenge copy()
/*     */     {
/* 707 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SchoolChallenge toData()
/*     */     {
/* 713 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SchoolChallenge toBean()
/*     */     {
/* 718 */       return new SchoolChallenge(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SchoolChallenge toDataIf()
/*     */     {
/* 724 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SchoolChallenge toBeanIf()
/*     */     {
/* 729 */       return new SchoolChallenge(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 735 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 739 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 743 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 747 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 751 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 755 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 759 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurrentring()
/*     */     {
/* 766 */       return this.currentring;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAwardcirclecount()
/*     */     {
/* 773 */       return this.awardcirclecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getTaskids()
/*     */     {
/* 780 */       return this.taskids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getTaskidsAsData()
/*     */     {
/* 787 */       return this.taskids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurrentring(int _v_)
/*     */     {
/* 794 */       this.currentring = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwardcirclecount(int _v_)
/*     */     {
/* 801 */       this.awardcirclecount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 807 */       if (!(_o1_ instanceof Data)) return false;
/* 808 */       Data _o_ = (Data)_o1_;
/* 809 */       if (this.currentring != _o_.currentring) return false;
/* 810 */       if (this.awardcirclecount != _o_.awardcirclecount) return false;
/* 811 */       if (!this.taskids.equals(_o_.taskids)) return false;
/* 812 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 818 */       int _h_ = 0;
/* 819 */       _h_ += this.currentring;
/* 820 */       _h_ += this.awardcirclecount;
/* 821 */       _h_ += this.taskids.hashCode();
/* 822 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 828 */       StringBuilder _sb_ = new StringBuilder();
/* 829 */       _sb_.append("(");
/* 830 */       _sb_.append(this.currentring);
/* 831 */       _sb_.append(",");
/* 832 */       _sb_.append(this.awardcirclecount);
/* 833 */       _sb_.append(",");
/* 834 */       _sb_.append(this.taskids);
/* 835 */       _sb_.append(")");
/* 836 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SchoolChallenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */