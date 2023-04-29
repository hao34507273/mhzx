/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class ShoppingIds extends XBean implements xbean.ShoppingIds
/*     */ {
/*     */   private LinkedList<Long> shoppingids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.shoppingids.clear();
/*     */   }
/*     */   
/*     */   ShoppingIds(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.shoppingids = new LinkedList();
/*     */   }
/*     */   
/*     */   public ShoppingIds()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ShoppingIds(ShoppingIds _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ShoppingIds(xbean.ShoppingIds _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof ShoppingIds)) { assign((ShoppingIds)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ShoppingIds _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.shoppingids = new LinkedList();
/*  50 */     this.shoppingids.addAll(_o_.shoppingids);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  55 */     this.shoppingids = new LinkedList();
/*  56 */     this.shoppingids.addAll(_o_.shoppingids);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  62 */     _xdb_verify_unsafe_();
/*  63 */     _os_.compact_uint32(this.shoppingids.size());
/*  64 */     for (Long _v_ : this.shoppingids)
/*     */     {
/*  66 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  77 */       long _v_ = 0L;
/*  78 */       _v_ = _os_.unmarshal_long();
/*  79 */       this.shoppingids.add(Long.valueOf(_v_));
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     int _size_ = 0;
/*  89 */     for (Long _v_ : this.shoppingids)
/*     */     {
/*  91 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/*  93 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 102 */       for (Long _v_ : this.shoppingids)
/*     */       {
/* 104 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           long _v_ = 0L;
/* 134 */           _v_ = _input_.readInt64();
/* 135 */           this.shoppingids.add(Long.valueOf(_v_));
/* 136 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 140 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 142 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 151 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 155 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 157 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ShoppingIds copy()
/*     */   {
/* 163 */     _xdb_verify_unsafe_();
/* 164 */     return new ShoppingIds(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ShoppingIds toData()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ShoppingIds toBean()
/*     */   {
/* 176 */     _xdb_verify_unsafe_();
/* 177 */     return new ShoppingIds(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ShoppingIds toDataIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ShoppingIds toBeanIf()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getShoppingids()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return xdb.Logs.logList(new xdb.LogKey(this, "shoppingids"), this.shoppingids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getShoppingidsAsData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/*     */     
/* 213 */     ShoppingIds _o_ = this;
/* 214 */     List<Long> shoppingids = new LinkedList();
/* 215 */     shoppingids.addAll(_o_.shoppingids);
/* 216 */     return shoppingids;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     ShoppingIds _o_ = null;
/* 224 */     if ((_o1_ instanceof ShoppingIds)) { _o_ = (ShoppingIds)_o1_;
/* 225 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 226 */       return false;
/* 227 */     if (!this.shoppingids.equals(_o_.shoppingids)) return false;
/* 228 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     int _h_ = 0;
/* 236 */     _h_ += this.shoppingids.hashCode();
/* 237 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 243 */     _xdb_verify_unsafe_();
/* 244 */     StringBuilder _sb_ = new StringBuilder();
/* 245 */     _sb_.append("(");
/* 246 */     _sb_.append(this.shoppingids);
/* 247 */     _sb_.append(")");
/* 248 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 254 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 255 */     lb.add(new xdb.logs.ListenableChanged().setVarName("shoppingids"));
/* 256 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ShoppingIds {
/*     */     private Const() {}
/*     */     
/*     */     ShoppingIds nThis() {
/* 263 */       return ShoppingIds.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 269 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingIds copy()
/*     */     {
/* 275 */       return ShoppingIds.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingIds toData()
/*     */     {
/* 281 */       return ShoppingIds.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ShoppingIds toBean()
/*     */     {
/* 286 */       return ShoppingIds.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingIds toDataIf()
/*     */     {
/* 292 */       return ShoppingIds.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ShoppingIds toBeanIf()
/*     */     {
/* 297 */       return ShoppingIds.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getShoppingids()
/*     */     {
/* 304 */       ShoppingIds.this._xdb_verify_unsafe_();
/* 305 */       return xdb.Consts.constList(ShoppingIds.this.shoppingids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getShoppingidsAsData()
/*     */     {
/* 311 */       ShoppingIds.this._xdb_verify_unsafe_();
/*     */       
/* 313 */       ShoppingIds _o_ = ShoppingIds.this;
/* 314 */       List<Long> shoppingids = new LinkedList();
/* 315 */       shoppingids.addAll(_o_.shoppingids);
/* 316 */       return shoppingids;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 322 */       ShoppingIds.this._xdb_verify_unsafe_();
/* 323 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 329 */       ShoppingIds.this._xdb_verify_unsafe_();
/* 330 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 336 */       return ShoppingIds.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 342 */       return ShoppingIds.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 348 */       ShoppingIds.this._xdb_verify_unsafe_();
/* 349 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 355 */       return ShoppingIds.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 361 */       return ShoppingIds.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 367 */       ShoppingIds.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 374 */       return ShoppingIds.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 380 */       return ShoppingIds.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 386 */       return ShoppingIds.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 392 */       return ShoppingIds.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 398 */       return ShoppingIds.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 404 */       return ShoppingIds.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 410 */       return ShoppingIds.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ShoppingIds
/*     */   {
/*     */     private LinkedList<Long> shoppingids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 422 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 427 */       this.shoppingids = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.ShoppingIds _o1_)
/*     */     {
/* 432 */       if ((_o1_ instanceof ShoppingIds)) { assign((ShoppingIds)_o1_);
/* 433 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 434 */       } else if ((_o1_ instanceof ShoppingIds.Const)) assign(((ShoppingIds.Const)_o1_).nThis()); else {
/* 435 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ShoppingIds _o_) {
/* 440 */       this.shoppingids = new LinkedList();
/* 441 */       this.shoppingids.addAll(_o_.shoppingids);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 446 */       this.shoppingids = new LinkedList();
/* 447 */       this.shoppingids.addAll(_o_.shoppingids);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 453 */       _os_.compact_uint32(this.shoppingids.size());
/* 454 */       for (Long _v_ : this.shoppingids)
/*     */       {
/* 456 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 458 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 464 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 466 */         long _v_ = 0L;
/* 467 */         _v_ = _os_.unmarshal_long();
/* 468 */         this.shoppingids.add(Long.valueOf(_v_));
/*     */       }
/* 470 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 476 */       int _size_ = 0;
/* 477 */       for (Long _v_ : this.shoppingids)
/*     */       {
/* 479 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 481 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 489 */         for (Long _v_ : this.shoppingids)
/*     */         {
/* 491 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 496 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 498 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 506 */         boolean done = false;
/* 507 */         while (!done)
/*     */         {
/* 509 */           int tag = _input_.readTag();
/* 510 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 514 */             done = true;
/* 515 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 519 */             long _v_ = 0L;
/* 520 */             _v_ = _input_.readInt64();
/* 521 */             this.shoppingids.add(Long.valueOf(_v_));
/* 522 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 526 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 528 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 537 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 541 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 543 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingIds copy()
/*     */     {
/* 549 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingIds toData()
/*     */     {
/* 555 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ShoppingIds toBean()
/*     */     {
/* 560 */       return new ShoppingIds(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingIds toDataIf()
/*     */     {
/* 566 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ShoppingIds toBeanIf()
/*     */     {
/* 571 */       return new ShoppingIds(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 577 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 589 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 593 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 597 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 601 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getShoppingids()
/*     */     {
/* 608 */       return this.shoppingids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getShoppingidsAsData()
/*     */     {
/* 615 */       return this.shoppingids;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 621 */       if (!(_o1_ instanceof Data)) return false;
/* 622 */       Data _o_ = (Data)_o1_;
/* 623 */       if (!this.shoppingids.equals(_o_.shoppingids)) return false;
/* 624 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 630 */       int _h_ = 0;
/* 631 */       _h_ += this.shoppingids.hashCode();
/* 632 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 638 */       StringBuilder _sb_ = new StringBuilder();
/* 639 */       _sb_.append("(");
/* 640 */       _sb_.append(this.shoppingids);
/* 641 */       _sb_.append(")");
/* 642 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ShoppingIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */