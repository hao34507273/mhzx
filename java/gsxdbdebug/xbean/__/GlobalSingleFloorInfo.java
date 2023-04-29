/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class GlobalSingleFloorInfo extends XBean implements xbean.GlobalSingleFloorInfo
/*     */ {
/*     */   private xbean.FloorFightRes firstblood;
/*     */   private xbean.FloorFightRes fastkill;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.firstblood._reset_unsafe_();
/*  21 */     this.fastkill._reset_unsafe_();
/*     */   }
/*     */   
/*     */   GlobalSingleFloorInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.firstblood = new FloorFightRes(0, this, "firstblood");
/*  28 */     this.fastkill = new FloorFightRes(0, this, "fastkill");
/*     */   }
/*     */   
/*     */   public GlobalSingleFloorInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GlobalSingleFloorInfo(GlobalSingleFloorInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GlobalSingleFloorInfo(xbean.GlobalSingleFloorInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof GlobalSingleFloorInfo)) { assign((GlobalSingleFloorInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GlobalSingleFloorInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.firstblood = new FloorFightRes(_o_.firstblood, this, "firstblood");
/*  54 */     this.fastkill = new FloorFightRes(_o_.fastkill, this, "fastkill");
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.firstblood = new FloorFightRes(_o_.firstblood, this, "firstblood");
/*  60 */     this.fastkill = new FloorFightRes(_o_.fastkill, this, "fastkill");
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _xdb_verify_unsafe_();
/*  67 */     this.firstblood.marshal(_os_);
/*  68 */     this.fastkill.marshal(_os_);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     this.firstblood.unmarshal(_os_);
/*  77 */     this.fastkill.unmarshal(_os_);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     int _size_ = 0;
/*  86 */     _size_ += CodedOutputStream.computeMessageSize(1, this.firstblood);
/*  87 */     _size_ += CodedOutputStream.computeMessageSize(2, this.fastkill);
/*  88 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  97 */       _output_.writeMessage(1, this.firstblood);
/*  98 */       _output_.writeMessage(2, this.fastkill);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 102 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 104 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 113 */       boolean done = false;
/* 114 */       while (!done)
/*     */       {
/* 116 */         int tag = _input_.readTag();
/* 117 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 121 */           done = true;
/* 122 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 126 */           _input_.readMessage(this.firstblood);
/* 127 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 131 */           _input_.readMessage(this.fastkill);
/* 132 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 136 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 138 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 147 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 151 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 153 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobalSingleFloorInfo copy()
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/* 160 */     return new GlobalSingleFloorInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobalSingleFloorInfo toData()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GlobalSingleFloorInfo toBean()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new GlobalSingleFloorInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobalSingleFloorInfo toDataIf()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GlobalSingleFloorInfo toBeanIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.FloorFightRes getFirstblood()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this.firstblood;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.FloorFightRes getFastkill()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return this.fastkill;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     GlobalSingleFloorInfo _o_ = null;
/* 217 */     if ((_o1_ instanceof GlobalSingleFloorInfo)) { _o_ = (GlobalSingleFloorInfo)_o1_;
/* 218 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 219 */       return false;
/* 220 */     if (!this.firstblood.equals(_o_.firstblood)) return false;
/* 221 */     if (!this.fastkill.equals(_o_.fastkill)) return false;
/* 222 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     int _h_ = 0;
/* 230 */     _h_ += this.firstblood.hashCode();
/* 231 */     _h_ += this.fastkill.hashCode();
/* 232 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     StringBuilder _sb_ = new StringBuilder();
/* 240 */     _sb_.append("(");
/* 241 */     _sb_.append(this.firstblood);
/* 242 */     _sb_.append(",");
/* 243 */     _sb_.append(this.fastkill);
/* 244 */     _sb_.append(")");
/* 245 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 251 */     ListenableBean lb = new ListenableBean();
/* 252 */     lb.add(new ListenableChanged().setVarName("firstblood"));
/* 253 */     lb.add(new ListenableChanged().setVarName("fastkill"));
/* 254 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GlobalSingleFloorInfo {
/*     */     private Const() {}
/*     */     
/*     */     GlobalSingleFloorInfo nThis() {
/* 261 */       return GlobalSingleFloorInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 267 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalSingleFloorInfo copy()
/*     */     {
/* 273 */       return GlobalSingleFloorInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalSingleFloorInfo toData()
/*     */     {
/* 279 */       return GlobalSingleFloorInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GlobalSingleFloorInfo toBean()
/*     */     {
/* 284 */       return GlobalSingleFloorInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalSingleFloorInfo toDataIf()
/*     */     {
/* 290 */       return GlobalSingleFloorInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GlobalSingleFloorInfo toBeanIf()
/*     */     {
/* 295 */       return GlobalSingleFloorInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.FloorFightRes getFirstblood()
/*     */     {
/* 302 */       GlobalSingleFloorInfo.this._xdb_verify_unsafe_();
/* 303 */       return (xbean.FloorFightRes)xdb.Consts.toConst(GlobalSingleFloorInfo.this.firstblood);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.FloorFightRes getFastkill()
/*     */     {
/* 310 */       GlobalSingleFloorInfo.this._xdb_verify_unsafe_();
/* 311 */       return (xbean.FloorFightRes)xdb.Consts.toConst(GlobalSingleFloorInfo.this.fastkill);
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 317 */       GlobalSingleFloorInfo.this._xdb_verify_unsafe_();
/* 318 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 324 */       GlobalSingleFloorInfo.this._xdb_verify_unsafe_();
/* 325 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 331 */       return GlobalSingleFloorInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 337 */       return GlobalSingleFloorInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 343 */       GlobalSingleFloorInfo.this._xdb_verify_unsafe_();
/* 344 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 350 */       return GlobalSingleFloorInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 356 */       return GlobalSingleFloorInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 362 */       GlobalSingleFloorInfo.this._xdb_verify_unsafe_();
/* 363 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 369 */       return GlobalSingleFloorInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 375 */       return GlobalSingleFloorInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 381 */       return GlobalSingleFloorInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 387 */       return GlobalSingleFloorInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 393 */       return GlobalSingleFloorInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 399 */       return GlobalSingleFloorInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 405 */       return GlobalSingleFloorInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GlobalSingleFloorInfo
/*     */   {
/*     */     private xbean.FloorFightRes firstblood;
/*     */     
/*     */     private xbean.FloorFightRes fastkill;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 424 */       this.firstblood = new FloorFightRes.Data();
/* 425 */       this.fastkill = new FloorFightRes.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.GlobalSingleFloorInfo _o1_)
/*     */     {
/* 430 */       if ((_o1_ instanceof GlobalSingleFloorInfo)) { assign((GlobalSingleFloorInfo)_o1_);
/* 431 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 432 */       } else if ((_o1_ instanceof GlobalSingleFloorInfo.Const)) assign(((GlobalSingleFloorInfo.Const)_o1_).nThis()); else {
/* 433 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GlobalSingleFloorInfo _o_) {
/* 438 */       this.firstblood = new FloorFightRes.Data(_o_.firstblood);
/* 439 */       this.fastkill = new FloorFightRes.Data(_o_.fastkill);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 444 */       this.firstblood = new FloorFightRes.Data(_o_.firstblood);
/* 445 */       this.fastkill = new FloorFightRes.Data(_o_.fastkill);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 451 */       this.firstblood.marshal(_os_);
/* 452 */       this.fastkill.marshal(_os_);
/* 453 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 459 */       this.firstblood.unmarshal(_os_);
/* 460 */       this.fastkill.unmarshal(_os_);
/* 461 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 467 */       int _size_ = 0;
/* 468 */       _size_ += CodedOutputStream.computeMessageSize(1, this.firstblood);
/* 469 */       _size_ += CodedOutputStream.computeMessageSize(2, this.fastkill);
/* 470 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 478 */         _output_.writeMessage(1, this.firstblood);
/* 479 */         _output_.writeMessage(2, this.fastkill);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 483 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 485 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 493 */         boolean done = false;
/* 494 */         while (!done)
/*     */         {
/* 496 */           int tag = _input_.readTag();
/* 497 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 501 */             done = true;
/* 502 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 506 */             _input_.readMessage(this.firstblood);
/* 507 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 511 */             _input_.readMessage(this.fastkill);
/* 512 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 516 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 518 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 527 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 531 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 533 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalSingleFloorInfo copy()
/*     */     {
/* 539 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalSingleFloorInfo toData()
/*     */     {
/* 545 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GlobalSingleFloorInfo toBean()
/*     */     {
/* 550 */       return new GlobalSingleFloorInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalSingleFloorInfo toDataIf()
/*     */     {
/* 556 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GlobalSingleFloorInfo toBeanIf()
/*     */     {
/* 561 */       return new GlobalSingleFloorInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 567 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 571 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 575 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 579 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 583 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 587 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 591 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.FloorFightRes getFirstblood()
/*     */     {
/* 598 */       return this.firstblood;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.FloorFightRes getFastkill()
/*     */     {
/* 605 */       return this.fastkill;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 611 */       if (!(_o1_ instanceof Data)) return false;
/* 612 */       Data _o_ = (Data)_o1_;
/* 613 */       if (!this.firstblood.equals(_o_.firstblood)) return false;
/* 614 */       if (!this.fastkill.equals(_o_.fastkill)) return false;
/* 615 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 621 */       int _h_ = 0;
/* 622 */       _h_ += this.firstblood.hashCode();
/* 623 */       _h_ += this.fastkill.hashCode();
/* 624 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 630 */       StringBuilder _sb_ = new StringBuilder();
/* 631 */       _sb_.append("(");
/* 632 */       _sb_.append(this.firstblood);
/* 633 */       _sb_.append(",");
/* 634 */       _sb_.append(this.fastkill);
/* 635 */       _sb_.append(")");
/* 636 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GlobalSingleFloorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */