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
/*     */ 
/*     */ public final class EachMoneyDayCostData extends XBean implements xbean.EachMoneyDayCostData
/*     */ {
/*     */   private long totalcost;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.totalcost = 0L;
/*     */   }
/*     */   
/*     */   EachMoneyDayCostData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public EachMoneyDayCostData()
/*     */   {
/*  28 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public EachMoneyDayCostData(EachMoneyDayCostData _o_)
/*     */   {
/*  33 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   EachMoneyDayCostData(xbean.EachMoneyDayCostData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  38 */     super(_xp_, _vn_);
/*  39 */     if ((_o1_ instanceof EachMoneyDayCostData)) { assign((EachMoneyDayCostData)_o1_);
/*  40 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  41 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  42 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(EachMoneyDayCostData _o_) {
/*  47 */     _o_._xdb_verify_unsafe_();
/*  48 */     this.totalcost = _o_.totalcost;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  53 */     this.totalcost = _o_.totalcost;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  59 */     _xdb_verify_unsafe_();
/*  60 */     _os_.marshal(this.totalcost);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     this.totalcost = _os_.unmarshal_long();
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     int _size_ = 0;
/*  77 */     _size_ += CodedOutputStream.computeInt64Size(1, this.totalcost);
/*  78 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  87 */       _output_.writeInt64(1, this.totalcost);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  91 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/*  93 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 102 */       boolean done = false;
/* 103 */       while (!done)
/*     */       {
/* 105 */         int tag = _input_.readTag();
/* 106 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 110 */           done = true;
/* 111 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 115 */           this.totalcost = _input_.readInt64();
/* 116 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 120 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 122 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 131 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 135 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 137 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.EachMoneyDayCostData copy()
/*     */   {
/* 143 */     _xdb_verify_unsafe_();
/* 144 */     return new EachMoneyDayCostData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.EachMoneyDayCostData toData()
/*     */   {
/* 150 */     _xdb_verify_unsafe_();
/* 151 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.EachMoneyDayCostData toBean()
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/* 157 */     return new EachMoneyDayCostData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.EachMoneyDayCostData toDataIf()
/*     */   {
/* 163 */     _xdb_verify_unsafe_();
/* 164 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.EachMoneyDayCostData toBeanIf()
/*     */   {
/* 169 */     _xdb_verify_unsafe_();
/* 170 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 176 */     _xdb_verify_unsafe_();
/* 177 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTotalcost()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return this.totalcost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalcost(long _v_)
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     xdb.Logs.logIf(new LogKey(this, "totalcost")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 197 */         new xdb.logs.LogLong(this, EachMoneyDayCostData.this.totalcost)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 201 */             EachMoneyDayCostData.this.totalcost = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 205 */     });
/* 206 */     this.totalcost = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     EachMoneyDayCostData _o_ = null;
/* 214 */     if ((_o1_ instanceof EachMoneyDayCostData)) { _o_ = (EachMoneyDayCostData)_o1_;
/* 215 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 216 */       return false;
/* 217 */     if (this.totalcost != _o_.totalcost) return false;
/* 218 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     int _h_ = 0;
/* 226 */     _h_ = (int)(_h_ + this.totalcost);
/* 227 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     StringBuilder _sb_ = new StringBuilder();
/* 235 */     _sb_.append("(");
/* 236 */     _sb_.append(this.totalcost);
/* 237 */     _sb_.append(")");
/* 238 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 244 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 245 */     lb.add(new xdb.logs.ListenableChanged().setVarName("totalcost"));
/* 246 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.EachMoneyDayCostData {
/*     */     private Const() {}
/*     */     
/*     */     EachMoneyDayCostData nThis() {
/* 253 */       return EachMoneyDayCostData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 259 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.EachMoneyDayCostData copy()
/*     */     {
/* 265 */       return EachMoneyDayCostData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.EachMoneyDayCostData toData()
/*     */     {
/* 271 */       return EachMoneyDayCostData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.EachMoneyDayCostData toBean()
/*     */     {
/* 276 */       return EachMoneyDayCostData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.EachMoneyDayCostData toDataIf()
/*     */     {
/* 282 */       return EachMoneyDayCostData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.EachMoneyDayCostData toBeanIf()
/*     */     {
/* 287 */       return EachMoneyDayCostData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTotalcost()
/*     */     {
/* 294 */       EachMoneyDayCostData.this._xdb_verify_unsafe_();
/* 295 */       return EachMoneyDayCostData.this.totalcost;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalcost(long _v_)
/*     */     {
/* 302 */       EachMoneyDayCostData.this._xdb_verify_unsafe_();
/* 303 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 309 */       EachMoneyDayCostData.this._xdb_verify_unsafe_();
/* 310 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 316 */       EachMoneyDayCostData.this._xdb_verify_unsafe_();
/* 317 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 323 */       return EachMoneyDayCostData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 329 */       return EachMoneyDayCostData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 335 */       EachMoneyDayCostData.this._xdb_verify_unsafe_();
/* 336 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 342 */       return EachMoneyDayCostData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 348 */       return EachMoneyDayCostData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 354 */       EachMoneyDayCostData.this._xdb_verify_unsafe_();
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 361 */       return EachMoneyDayCostData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 367 */       return EachMoneyDayCostData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 373 */       return EachMoneyDayCostData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 379 */       return EachMoneyDayCostData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 385 */       return EachMoneyDayCostData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 391 */       return EachMoneyDayCostData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 397 */       return EachMoneyDayCostData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.EachMoneyDayCostData
/*     */   {
/*     */     private long totalcost;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 409 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.EachMoneyDayCostData _o1_)
/*     */     {
/* 418 */       if ((_o1_ instanceof EachMoneyDayCostData)) { assign((EachMoneyDayCostData)_o1_);
/* 419 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 420 */       } else if ((_o1_ instanceof EachMoneyDayCostData.Const)) assign(((EachMoneyDayCostData.Const)_o1_).nThis()); else {
/* 421 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(EachMoneyDayCostData _o_) {
/* 426 */       this.totalcost = _o_.totalcost;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 431 */       this.totalcost = _o_.totalcost;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 437 */       _os_.marshal(this.totalcost);
/* 438 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 444 */       this.totalcost = _os_.unmarshal_long();
/* 445 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 451 */       int _size_ = 0;
/* 452 */       _size_ += CodedOutputStream.computeInt64Size(1, this.totalcost);
/* 453 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 461 */         _output_.writeInt64(1, this.totalcost);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 465 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 467 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 475 */         boolean done = false;
/* 476 */         while (!done)
/*     */         {
/* 478 */           int tag = _input_.readTag();
/* 479 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 483 */             done = true;
/* 484 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 488 */             this.totalcost = _input_.readInt64();
/* 489 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 493 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 495 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 504 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 508 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 510 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.EachMoneyDayCostData copy()
/*     */     {
/* 516 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.EachMoneyDayCostData toData()
/*     */     {
/* 522 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.EachMoneyDayCostData toBean()
/*     */     {
/* 527 */       return new EachMoneyDayCostData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.EachMoneyDayCostData toDataIf()
/*     */     {
/* 533 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.EachMoneyDayCostData toBeanIf()
/*     */     {
/* 538 */       return new EachMoneyDayCostData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 552 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 560 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 564 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 568 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTotalcost()
/*     */     {
/* 575 */       return this.totalcost;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalcost(long _v_)
/*     */     {
/* 582 */       this.totalcost = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 588 */       if (!(_o1_ instanceof Data)) return false;
/* 589 */       Data _o_ = (Data)_o1_;
/* 590 */       if (this.totalcost != _o_.totalcost) return false;
/* 591 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 597 */       int _h_ = 0;
/* 598 */       _h_ = (int)(_h_ + this.totalcost);
/* 599 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 605 */       StringBuilder _sb_ = new StringBuilder();
/* 606 */       _sb_.append("(");
/* 607 */       _sb_.append(this.totalcost);
/* 608 */       _sb_.append(")");
/* 609 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\EachMoneyDayCostData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */