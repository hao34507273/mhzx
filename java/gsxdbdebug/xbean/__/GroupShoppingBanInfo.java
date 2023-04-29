/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class GroupShoppingBanInfo extends xdb.XBean implements xbean.GroupShoppingBanInfo
/*     */ {
/*     */   private SetX<Integer> banned_group_shopping_items;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.banned_group_shopping_items.clear();
/*     */   }
/*     */   
/*     */   GroupShoppingBanInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.banned_group_shopping_items = new SetX();
/*     */   }
/*     */   
/*     */   public GroupShoppingBanInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GroupShoppingBanInfo(GroupShoppingBanInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GroupShoppingBanInfo(xbean.GroupShoppingBanInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof GroupShoppingBanInfo)) { assign((GroupShoppingBanInfo)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GroupShoppingBanInfo _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.banned_group_shopping_items = new SetX();
/*  50 */     this.banned_group_shopping_items.addAll(_o_.banned_group_shopping_items);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  55 */     this.banned_group_shopping_items = new SetX();
/*  56 */     this.banned_group_shopping_items.addAll(_o_.banned_group_shopping_items);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  62 */     _xdb_verify_unsafe_();
/*  63 */     _os_.compact_uint32(this.banned_group_shopping_items.size());
/*  64 */     for (Integer _v_ : this.banned_group_shopping_items)
/*     */     {
/*  66 */       _os_.marshal(_v_.intValue());
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
/*  77 */       int _v_ = 0;
/*  78 */       _v_ = _os_.unmarshal_int();
/*  79 */       this.banned_group_shopping_items.add(Integer.valueOf(_v_));
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     int _size_ = 0;
/*  89 */     for (Integer _v_ : this.banned_group_shopping_items)
/*     */     {
/*  91 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
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
/* 102 */       for (Integer _v_ : this.banned_group_shopping_items)
/*     */       {
/* 104 */         _output_.writeInt32(1, _v_.intValue());
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
/* 133 */           int _v_ = 0;
/* 134 */           _v_ = _input_.readInt32();
/* 135 */           this.banned_group_shopping_items.add(Integer.valueOf(_v_));
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
/*     */   public xbean.GroupShoppingBanInfo copy()
/*     */   {
/* 163 */     _xdb_verify_unsafe_();
/* 164 */     return new GroupShoppingBanInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GroupShoppingBanInfo toData()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GroupShoppingBanInfo toBean()
/*     */   {
/* 176 */     _xdb_verify_unsafe_();
/* 177 */     return new GroupShoppingBanInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GroupShoppingBanInfo toDataIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GroupShoppingBanInfo toBeanIf()
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
/*     */   public Set<Integer> getBanned_group_shopping_items()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return xdb.Logs.logSet(new xdb.LogKey(this, "banned_group_shopping_items"), this.banned_group_shopping_items);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getBanned_group_shopping_itemsAsData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/*     */     
/* 213 */     GroupShoppingBanInfo _o_ = this;
/* 214 */     Set<Integer> banned_group_shopping_items = new SetX();
/* 215 */     banned_group_shopping_items.addAll(_o_.banned_group_shopping_items);
/* 216 */     return banned_group_shopping_items;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     GroupShoppingBanInfo _o_ = null;
/* 224 */     if ((_o1_ instanceof GroupShoppingBanInfo)) { _o_ = (GroupShoppingBanInfo)_o1_;
/* 225 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 226 */       return false;
/* 227 */     if (!this.banned_group_shopping_items.equals(_o_.banned_group_shopping_items)) return false;
/* 228 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     int _h_ = 0;
/* 236 */     _h_ += this.banned_group_shopping_items.hashCode();
/* 237 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 243 */     _xdb_verify_unsafe_();
/* 244 */     StringBuilder _sb_ = new StringBuilder();
/* 245 */     _sb_.append("(");
/* 246 */     _sb_.append(this.banned_group_shopping_items);
/* 247 */     _sb_.append(")");
/* 248 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 254 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 255 */     lb.add(new xdb.logs.ListenableSet().setVarName("banned_group_shopping_items"));
/* 256 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GroupShoppingBanInfo {
/*     */     private Const() {}
/*     */     
/*     */     GroupShoppingBanInfo nThis() {
/* 263 */       return GroupShoppingBanInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 269 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupShoppingBanInfo copy()
/*     */     {
/* 275 */       return GroupShoppingBanInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupShoppingBanInfo toData()
/*     */     {
/* 281 */       return GroupShoppingBanInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GroupShoppingBanInfo toBean()
/*     */     {
/* 286 */       return GroupShoppingBanInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupShoppingBanInfo toDataIf()
/*     */     {
/* 292 */       return GroupShoppingBanInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GroupShoppingBanInfo toBeanIf()
/*     */     {
/* 297 */       return GroupShoppingBanInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getBanned_group_shopping_items()
/*     */     {
/* 304 */       GroupShoppingBanInfo.this._xdb_verify_unsafe_();
/* 305 */       return xdb.Consts.constSet(GroupShoppingBanInfo.this.banned_group_shopping_items);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getBanned_group_shopping_itemsAsData()
/*     */     {
/* 311 */       GroupShoppingBanInfo.this._xdb_verify_unsafe_();
/*     */       
/* 313 */       GroupShoppingBanInfo _o_ = GroupShoppingBanInfo.this;
/* 314 */       Set<Integer> banned_group_shopping_items = new SetX();
/* 315 */       banned_group_shopping_items.addAll(_o_.banned_group_shopping_items);
/* 316 */       return banned_group_shopping_items;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 322 */       GroupShoppingBanInfo.this._xdb_verify_unsafe_();
/* 323 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 329 */       GroupShoppingBanInfo.this._xdb_verify_unsafe_();
/* 330 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 336 */       return GroupShoppingBanInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 342 */       return GroupShoppingBanInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 348 */       GroupShoppingBanInfo.this._xdb_verify_unsafe_();
/* 349 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 355 */       return GroupShoppingBanInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 361 */       return GroupShoppingBanInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 367 */       GroupShoppingBanInfo.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 374 */       return GroupShoppingBanInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 380 */       return GroupShoppingBanInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 386 */       return GroupShoppingBanInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 392 */       return GroupShoppingBanInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 398 */       return GroupShoppingBanInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 404 */       return GroupShoppingBanInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 410 */       return GroupShoppingBanInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GroupShoppingBanInfo
/*     */   {
/*     */     private HashSet<Integer> banned_group_shopping_items;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 422 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 427 */       this.banned_group_shopping_items = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.GroupShoppingBanInfo _o1_)
/*     */     {
/* 432 */       if ((_o1_ instanceof GroupShoppingBanInfo)) { assign((GroupShoppingBanInfo)_o1_);
/* 433 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 434 */       } else if ((_o1_ instanceof GroupShoppingBanInfo.Const)) assign(((GroupShoppingBanInfo.Const)_o1_).nThis()); else {
/* 435 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GroupShoppingBanInfo _o_) {
/* 440 */       this.banned_group_shopping_items = new HashSet();
/* 441 */       this.banned_group_shopping_items.addAll(_o_.banned_group_shopping_items);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 446 */       this.banned_group_shopping_items = new HashSet();
/* 447 */       this.banned_group_shopping_items.addAll(_o_.banned_group_shopping_items);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 453 */       _os_.compact_uint32(this.banned_group_shopping_items.size());
/* 454 */       for (Integer _v_ : this.banned_group_shopping_items)
/*     */       {
/* 456 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 458 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 464 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 466 */         int _v_ = 0;
/* 467 */         _v_ = _os_.unmarshal_int();
/* 468 */         this.banned_group_shopping_items.add(Integer.valueOf(_v_));
/*     */       }
/* 470 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 476 */       int _size_ = 0;
/* 477 */       for (Integer _v_ : this.banned_group_shopping_items)
/*     */       {
/* 479 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */       }
/* 481 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 489 */         for (Integer _v_ : this.banned_group_shopping_items)
/*     */         {
/* 491 */           _output_.writeInt32(1, _v_.intValue());
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
/* 519 */             int _v_ = 0;
/* 520 */             _v_ = _input_.readInt32();
/* 521 */             this.banned_group_shopping_items.add(Integer.valueOf(_v_));
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
/*     */     public xbean.GroupShoppingBanInfo copy()
/*     */     {
/* 549 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupShoppingBanInfo toData()
/*     */     {
/* 555 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GroupShoppingBanInfo toBean()
/*     */     {
/* 560 */       return new GroupShoppingBanInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupShoppingBanInfo toDataIf()
/*     */     {
/* 566 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GroupShoppingBanInfo toBeanIf()
/*     */     {
/* 571 */       return new GroupShoppingBanInfo(this, null, null);
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
/*     */     public Set<Integer> getBanned_group_shopping_items()
/*     */     {
/* 608 */       return this.banned_group_shopping_items;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getBanned_group_shopping_itemsAsData()
/*     */     {
/* 615 */       return this.banned_group_shopping_items;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 621 */       if (!(_o1_ instanceof Data)) return false;
/* 622 */       Data _o_ = (Data)_o1_;
/* 623 */       if (!this.banned_group_shopping_items.equals(_o_.banned_group_shopping_items)) return false;
/* 624 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 630 */       int _h_ = 0;
/* 631 */       _h_ += this.banned_group_shopping_items.hashCode();
/* 632 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 638 */       StringBuilder _sb_ = new StringBuilder();
/* 639 */       _sb_.append("(");
/* 640 */       _sb_.append(this.banned_group_shopping_items);
/* 641 */       _sb_.append(")");
/* 642 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GroupShoppingBanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */