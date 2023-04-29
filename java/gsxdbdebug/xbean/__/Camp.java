/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class Camp extends XBean implements xbean.Camp
/*     */ {
/*     */   private int role_number;
/*     */   private int score;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.role_number = 0;
/*  21 */     this.score = 0;
/*     */   }
/*     */   
/*     */   Camp(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.role_number = 0;
/*     */   }
/*     */   
/*     */   public Camp()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Camp(Camp _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Camp(xbean.Camp _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof Camp)) { assign((Camp)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Camp _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.role_number = _o_.role_number;
/*  53 */     this.score = _o_.score;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  58 */     this.role_number = _o_.role_number;
/*  59 */     this.score = _o_.score;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _xdb_verify_unsafe_();
/*  66 */     _os_.marshal(this.role_number);
/*  67 */     _os_.marshal(this.score);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     this.role_number = _os_.unmarshal_int();
/*  76 */     this.score = _os_.unmarshal_int();
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     int _size_ = 0;
/*  85 */     _size_ += CodedOutputStream.computeInt32Size(2, this.role_number);
/*  86 */     _size_ += CodedOutputStream.computeInt32Size(3, this.score);
/*  87 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  96 */       _output_.writeInt32(2, this.role_number);
/*  97 */       _output_.writeInt32(3, this.score);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 101 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 103 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       boolean done = false;
/* 113 */       while (!done)
/*     */       {
/* 115 */         int tag = _input_.readTag();
/* 116 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 120 */           done = true;
/* 121 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 125 */           this.role_number = _input_.readInt32();
/* 126 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 130 */           this.score = _input_.readInt32();
/* 131 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 135 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 137 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 146 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Camp copy()
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/* 159 */     return new Camp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Camp toData()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Camp toBean()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new Camp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Camp toDataIf()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Camp toBeanIf()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRole_number()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return this.role_number;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getScore()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return this.score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRole_number(int _v_)
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     xdb.Logs.logIf(new LogKey(this, "role_number")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 220 */         new xdb.logs.LogInt(this, Camp.this.role_number)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 224 */             Camp.this.role_number = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 228 */     });
/* 229 */     this.role_number = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setScore(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "score")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, Camp.this.score)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             Camp.this.score = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.score = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     Camp _o_ = null;
/* 258 */     if ((_o1_ instanceof Camp)) { _o_ = (Camp)_o1_;
/* 259 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 260 */       return false;
/* 261 */     if (this.role_number != _o_.role_number) return false;
/* 262 */     if (this.score != _o_.score) return false;
/* 263 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     int _h_ = 0;
/* 271 */     _h_ += this.role_number;
/* 272 */     _h_ += this.score;
/* 273 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     StringBuilder _sb_ = new StringBuilder();
/* 281 */     _sb_.append("(");
/* 282 */     _sb_.append(this.role_number);
/* 283 */     _sb_.append(",");
/* 284 */     _sb_.append(this.score);
/* 285 */     _sb_.append(")");
/* 286 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 292 */     ListenableBean lb = new ListenableBean();
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("role_number"));
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("score"));
/* 295 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Camp {
/*     */     private Const() {}
/*     */     
/*     */     Camp nThis() {
/* 302 */       return Camp.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 308 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Camp copy()
/*     */     {
/* 314 */       return Camp.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Camp toData()
/*     */     {
/* 320 */       return Camp.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Camp toBean()
/*     */     {
/* 325 */       return Camp.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Camp toDataIf()
/*     */     {
/* 331 */       return Camp.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Camp toBeanIf()
/*     */     {
/* 336 */       return Camp.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRole_number()
/*     */     {
/* 343 */       Camp.this._xdb_verify_unsafe_();
/* 344 */       return Camp.this.role_number;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getScore()
/*     */     {
/* 351 */       Camp.this._xdb_verify_unsafe_();
/* 352 */       return Camp.this.score;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_number(int _v_)
/*     */     {
/* 359 */       Camp.this._xdb_verify_unsafe_();
/* 360 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setScore(int _v_)
/*     */     {
/* 367 */       Camp.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 374 */       Camp.this._xdb_verify_unsafe_();
/* 375 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 381 */       Camp.this._xdb_verify_unsafe_();
/* 382 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 388 */       return Camp.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 394 */       return Camp.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 400 */       Camp.this._xdb_verify_unsafe_();
/* 401 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 407 */       return Camp.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 413 */       return Camp.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 419 */       Camp.this._xdb_verify_unsafe_();
/* 420 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 426 */       return Camp.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 432 */       return Camp.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 438 */       return Camp.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 444 */       return Camp.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 450 */       return Camp.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 456 */       return Camp.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 462 */       return Camp.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Camp
/*     */   {
/*     */     private int role_number;
/*     */     
/*     */     private int score;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 481 */       this.role_number = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.Camp _o1_)
/*     */     {
/* 486 */       if ((_o1_ instanceof Camp)) { assign((Camp)_o1_);
/* 487 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 488 */       } else if ((_o1_ instanceof Camp.Const)) assign(((Camp.Const)_o1_).nThis()); else {
/* 489 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Camp _o_) {
/* 494 */       this.role_number = _o_.role_number;
/* 495 */       this.score = _o_.score;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 500 */       this.role_number = _o_.role_number;
/* 501 */       this.score = _o_.score;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 507 */       _os_.marshal(this.role_number);
/* 508 */       _os_.marshal(this.score);
/* 509 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 515 */       this.role_number = _os_.unmarshal_int();
/* 516 */       this.score = _os_.unmarshal_int();
/* 517 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 523 */       int _size_ = 0;
/* 524 */       _size_ += CodedOutputStream.computeInt32Size(2, this.role_number);
/* 525 */       _size_ += CodedOutputStream.computeInt32Size(3, this.score);
/* 526 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 534 */         _output_.writeInt32(2, this.role_number);
/* 535 */         _output_.writeInt32(3, this.score);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 539 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 541 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 549 */         boolean done = false;
/* 550 */         while (!done)
/*     */         {
/* 552 */           int tag = _input_.readTag();
/* 553 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 557 */             done = true;
/* 558 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 562 */             this.role_number = _input_.readInt32();
/* 563 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 567 */             this.score = _input_.readInt32();
/* 568 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 572 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 574 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 583 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 587 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 589 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Camp copy()
/*     */     {
/* 595 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Camp toData()
/*     */     {
/* 601 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Camp toBean()
/*     */     {
/* 606 */       return new Camp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Camp toDataIf()
/*     */     {
/* 612 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Camp toBeanIf()
/*     */     {
/* 617 */       return new Camp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 627 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 631 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 635 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 639 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 643 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 647 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRole_number()
/*     */     {
/* 654 */       return this.role_number;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getScore()
/*     */     {
/* 661 */       return this.score;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_number(int _v_)
/*     */     {
/* 668 */       this.role_number = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setScore(int _v_)
/*     */     {
/* 675 */       this.score = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 681 */       if (!(_o1_ instanceof Data)) return false;
/* 682 */       Data _o_ = (Data)_o1_;
/* 683 */       if (this.role_number != _o_.role_number) return false;
/* 684 */       if (this.score != _o_.score) return false;
/* 685 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 691 */       int _h_ = 0;
/* 692 */       _h_ += this.role_number;
/* 693 */       _h_ += this.score;
/* 694 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 700 */       StringBuilder _sb_ = new StringBuilder();
/* 701 */       _sb_.append("(");
/* 702 */       _sb_.append(this.role_number);
/* 703 */       _sb_.append(",");
/* 704 */       _sb_.append(this.score);
/* 705 */       _sb_.append(")");
/* 706 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Camp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */