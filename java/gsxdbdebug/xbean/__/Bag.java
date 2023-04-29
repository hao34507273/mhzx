/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class Bag extends XBean implements xbean.Bag
/*     */ {
/*     */   private String bagname;
/*     */   private int capacity;
/*     */   private HashMap<Integer, xbean.Item> items;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.bagname = "";
/*  23 */     this.capacity = 0;
/*  24 */     this.items.clear();
/*     */   }
/*     */   
/*     */   Bag(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.bagname = "";
/*  31 */     this.items = new HashMap();
/*     */   }
/*     */   
/*     */   public Bag()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Bag(Bag _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Bag(xbean.Bag _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof Bag)) { assign((Bag)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Bag _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.bagname = _o_.bagname;
/*  57 */     this.capacity = _o_.capacity;
/*  58 */     this.items = new HashMap();
/*  59 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.items.entrySet()) {
/*  60 */       this.items.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "items"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  65 */     this.bagname = _o_.bagname;
/*  66 */     this.capacity = _o_.capacity;
/*  67 */     this.items = new HashMap();
/*  68 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.items.entrySet()) {
/*  69 */       this.items.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "items"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.marshal(this.bagname, "UTF-16LE");
/*  77 */     _os_.marshal(this.capacity);
/*  78 */     _os_.compact_uint32(this.items.size());
/*  79 */     for (Map.Entry<Integer, xbean.Item> _e_ : this.items.entrySet())
/*     */     {
/*  81 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  82 */       ((xbean.Item)_e_.getValue()).marshal(_os_);
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     this.bagname = _os_.unmarshal_String("UTF-16LE");
/*  92 */     this.capacity = _os_.unmarshal_int();
/*     */     
/*  94 */     int size = _os_.uncompact_uint32();
/*  95 */     if (size >= 12)
/*     */     {
/*  97 */       this.items = new HashMap(size * 2);
/*     */     }
/*  99 */     for (; size > 0; size--)
/*     */     {
/* 101 */       int _k_ = 0;
/* 102 */       _k_ = _os_.unmarshal_int();
/* 103 */       xbean.Item _v_ = new Item(0, this, "items");
/* 104 */       _v_.unmarshal(_os_);
/* 105 */       this.items.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 114 */     _xdb_verify_unsafe_();
/* 115 */     int _size_ = 0;
/*     */     try
/*     */     {
/* 118 */       _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom(this.bagname, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/* 122 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 124 */     _size_ += CodedOutputStream.computeInt32Size(2, this.capacity);
/* 125 */     for (Map.Entry<Integer, xbean.Item> _e_ : this.items.entrySet())
/*     */     {
/* 127 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 128 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */     }
/* 130 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 139 */       _output_.writeBytes(1, ppbio.ByteString.copyFrom(this.bagname, "UTF-16LE"));
/* 140 */       _output_.writeInt32(2, this.capacity);
/* 141 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.items.entrySet())
/*     */       {
/* 143 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 144 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 151 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 160 */       boolean done = false;
/* 161 */       while (!done)
/*     */       {
/* 163 */         int tag = _input_.readTag();
/* 164 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 168 */           done = true;
/* 169 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 173 */           this.bagname = _input_.readBytes().toString("UTF-16LE");
/* 174 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 178 */           this.capacity = _input_.readInt32();
/* 179 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 183 */           int _k_ = 0;
/* 184 */           _k_ = _input_.readInt32();
/* 185 */           int readTag = _input_.readTag();
/* 186 */           if (26 != readTag)
/*     */           {
/* 188 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 190 */           xbean.Item _v_ = new Item(0, this, "items");
/* 191 */           _input_.readMessage(_v_);
/* 192 */           this.items.put(Integer.valueOf(_k_), _v_);
/* 193 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 197 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 199 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 208 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 212 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 214 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Bag copy()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Bag(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Bag toData()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Bag toBean()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Bag(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Bag toDataIf()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Bag toBeanIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBagname()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.bagname;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getBagnameOctets()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return Octets.wrap(getBagname(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCapacity()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/* 278 */     return this.capacity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.Item> getItems()
/*     */   {
/* 285 */     _xdb_verify_unsafe_();
/* 286 */     return xdb.Logs.logMap(new LogKey(this, "items"), this.items);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.Item> getItemsAsData()
/*     */   {
/* 293 */     _xdb_verify_unsafe_();
/*     */     
/* 295 */     Bag _o_ = this;
/* 296 */     Map<Integer, xbean.Item> items = new HashMap();
/* 297 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.items.entrySet())
/* 298 */       items.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/* 299 */     return items;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBagname(String _v_)
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     if (null == _v_)
/* 308 */       throw new NullPointerException();
/* 309 */     xdb.Logs.logIf(new LogKey(this, "bagname")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 313 */         new xdb.logs.LogString(this, Bag.this.bagname)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 317 */             Bag.this.bagname = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 321 */     });
/* 322 */     this.bagname = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBagnameOctets(Octets _v_)
/*     */   {
/* 329 */     _xdb_verify_unsafe_();
/* 330 */     setBagname(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCapacity(int _v_)
/*     */   {
/* 337 */     _xdb_verify_unsafe_();
/* 338 */     xdb.Logs.logIf(new LogKey(this, "capacity")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 342 */         new xdb.logs.LogInt(this, Bag.this.capacity)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 346 */             Bag.this.capacity = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 350 */     });
/* 351 */     this.capacity = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 357 */     _xdb_verify_unsafe_();
/* 358 */     Bag _o_ = null;
/* 359 */     if ((_o1_ instanceof Bag)) { _o_ = (Bag)_o1_;
/* 360 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 361 */       return false;
/* 362 */     if (!this.bagname.equals(_o_.bagname)) return false;
/* 363 */     if (this.capacity != _o_.capacity) return false;
/* 364 */     if (!this.items.equals(_o_.items)) return false;
/* 365 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 371 */     _xdb_verify_unsafe_();
/* 372 */     int _h_ = 0;
/* 373 */     _h_ += this.bagname.hashCode();
/* 374 */     _h_ += this.capacity;
/* 375 */     _h_ += this.items.hashCode();
/* 376 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 382 */     _xdb_verify_unsafe_();
/* 383 */     StringBuilder _sb_ = new StringBuilder();
/* 384 */     _sb_.append("(");
/* 385 */     _sb_.append("'").append(this.bagname).append("'");
/* 386 */     _sb_.append(",");
/* 387 */     _sb_.append(this.capacity);
/* 388 */     _sb_.append(",");
/* 389 */     _sb_.append(this.items);
/* 390 */     _sb_.append(")");
/* 391 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 397 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 398 */     lb.add(new xdb.logs.ListenableChanged().setVarName("bagname"));
/* 399 */     lb.add(new xdb.logs.ListenableChanged().setVarName("capacity"));
/* 400 */     lb.add(new xdb.logs.ListenableMap().setVarName("items"));
/* 401 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Bag {
/*     */     private Const() {}
/*     */     
/*     */     Bag nThis() {
/* 408 */       return Bag.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 414 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Bag copy()
/*     */     {
/* 420 */       return Bag.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Bag toData()
/*     */     {
/* 426 */       return Bag.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Bag toBean()
/*     */     {
/* 431 */       return Bag.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Bag toDataIf()
/*     */     {
/* 437 */       return Bag.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Bag toBeanIf()
/*     */     {
/* 442 */       return Bag.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getBagname()
/*     */     {
/* 449 */       Bag.this._xdb_verify_unsafe_();
/* 450 */       return Bag.this.bagname;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getBagnameOctets()
/*     */     {
/* 457 */       Bag.this._xdb_verify_unsafe_();
/* 458 */       return Bag.this.getBagnameOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCapacity()
/*     */     {
/* 465 */       Bag.this._xdb_verify_unsafe_();
/* 466 */       return Bag.this.capacity;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Item> getItems()
/*     */     {
/* 473 */       Bag.this._xdb_verify_unsafe_();
/* 474 */       return xdb.Consts.constMap(Bag.this.items);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Item> getItemsAsData()
/*     */     {
/* 481 */       Bag.this._xdb_verify_unsafe_();
/*     */       
/* 483 */       Bag _o_ = Bag.this;
/* 484 */       Map<Integer, xbean.Item> items = new HashMap();
/* 485 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.items.entrySet())
/* 486 */         items.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/* 487 */       return items;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBagname(String _v_)
/*     */     {
/* 494 */       Bag.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBagnameOctets(Octets _v_)
/*     */     {
/* 502 */       Bag.this._xdb_verify_unsafe_();
/* 503 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCapacity(int _v_)
/*     */     {
/* 510 */       Bag.this._xdb_verify_unsafe_();
/* 511 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 517 */       Bag.this._xdb_verify_unsafe_();
/* 518 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 524 */       Bag.this._xdb_verify_unsafe_();
/* 525 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 531 */       return Bag.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 537 */       return Bag.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 543 */       Bag.this._xdb_verify_unsafe_();
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 550 */       return Bag.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 556 */       return Bag.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 562 */       Bag.this._xdb_verify_unsafe_();
/* 563 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 569 */       return Bag.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 575 */       return Bag.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 581 */       return Bag.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 587 */       return Bag.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 593 */       return Bag.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 599 */       return Bag.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 605 */       return Bag.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Bag
/*     */   {
/*     */     private String bagname;
/*     */     
/*     */     private int capacity;
/*     */     
/*     */     private HashMap<Integer, xbean.Item> items;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 626 */       this.bagname = "";
/* 627 */       this.items = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.Bag _o1_)
/*     */     {
/* 632 */       if ((_o1_ instanceof Bag)) { assign((Bag)_o1_);
/* 633 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 634 */       } else if ((_o1_ instanceof Bag.Const)) assign(((Bag.Const)_o1_).nThis()); else {
/* 635 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Bag _o_) {
/* 640 */       this.bagname = _o_.bagname;
/* 641 */       this.capacity = _o_.capacity;
/* 642 */       this.items = new HashMap();
/* 643 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.items.entrySet()) {
/* 644 */         this.items.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 649 */       this.bagname = _o_.bagname;
/* 650 */       this.capacity = _o_.capacity;
/* 651 */       this.items = new HashMap();
/* 652 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.items.entrySet()) {
/* 653 */         this.items.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 659 */       _os_.marshal(this.bagname, "UTF-16LE");
/* 660 */       _os_.marshal(this.capacity);
/* 661 */       _os_.compact_uint32(this.items.size());
/* 662 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.items.entrySet())
/*     */       {
/* 664 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 665 */         ((xbean.Item)_e_.getValue()).marshal(_os_);
/*     */       }
/* 667 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 673 */       this.bagname = _os_.unmarshal_String("UTF-16LE");
/* 674 */       this.capacity = _os_.unmarshal_int();
/*     */       
/* 676 */       int size = _os_.uncompact_uint32();
/* 677 */       if (size >= 12)
/*     */       {
/* 679 */         this.items = new HashMap(size * 2);
/*     */       }
/* 681 */       for (; size > 0; size--)
/*     */       {
/* 683 */         int _k_ = 0;
/* 684 */         _k_ = _os_.unmarshal_int();
/* 685 */         xbean.Item _v_ = xbean.Pod.newItemData();
/* 686 */         _v_.unmarshal(_os_);
/* 687 */         this.items.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 690 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 696 */       int _size_ = 0;
/*     */       try
/*     */       {
/* 699 */         _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom(this.bagname, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 703 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 705 */       _size_ += CodedOutputStream.computeInt32Size(2, this.capacity);
/* 706 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.items.entrySet())
/*     */       {
/* 708 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 709 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 711 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 719 */         _output_.writeBytes(1, ppbio.ByteString.copyFrom(this.bagname, "UTF-16LE"));
/* 720 */         _output_.writeInt32(2, this.capacity);
/* 721 */         for (Map.Entry<Integer, xbean.Item> _e_ : this.items.entrySet())
/*     */         {
/* 723 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 724 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 729 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 731 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 739 */         boolean done = false;
/* 740 */         while (!done)
/*     */         {
/* 742 */           int tag = _input_.readTag();
/* 743 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 747 */             done = true;
/* 748 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 752 */             this.bagname = _input_.readBytes().toString("UTF-16LE");
/* 753 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 757 */             this.capacity = _input_.readInt32();
/* 758 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 762 */             int _k_ = 0;
/* 763 */             _k_ = _input_.readInt32();
/* 764 */             int readTag = _input_.readTag();
/* 765 */             if (26 != readTag)
/*     */             {
/* 767 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 769 */             xbean.Item _v_ = xbean.Pod.newItemData();
/* 770 */             _input_.readMessage(_v_);
/* 771 */             this.items.put(Integer.valueOf(_k_), _v_);
/* 772 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 776 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 778 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 787 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 791 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 793 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Bag copy()
/*     */     {
/* 799 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Bag toData()
/*     */     {
/* 805 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Bag toBean()
/*     */     {
/* 810 */       return new Bag(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Bag toDataIf()
/*     */     {
/* 816 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Bag toBeanIf()
/*     */     {
/* 821 */       return new Bag(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 827 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 831 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 835 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 839 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 843 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 847 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 851 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getBagname()
/*     */     {
/* 858 */       return this.bagname;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getBagnameOctets()
/*     */     {
/* 865 */       return Octets.wrap(getBagname(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCapacity()
/*     */     {
/* 872 */       return this.capacity;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Item> getItems()
/*     */     {
/* 879 */       return this.items;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Item> getItemsAsData()
/*     */     {
/* 886 */       return this.items;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBagname(String _v_)
/*     */     {
/* 893 */       if (null == _v_)
/* 894 */         throw new NullPointerException();
/* 895 */       this.bagname = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBagnameOctets(Octets _v_)
/*     */     {
/* 902 */       setBagname(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCapacity(int _v_)
/*     */     {
/* 909 */       this.capacity = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 915 */       if (!(_o1_ instanceof Data)) return false;
/* 916 */       Data _o_ = (Data)_o1_;
/* 917 */       if (!this.bagname.equals(_o_.bagname)) return false;
/* 918 */       if (this.capacity != _o_.capacity) return false;
/* 919 */       if (!this.items.equals(_o_.items)) return false;
/* 920 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 926 */       int _h_ = 0;
/* 927 */       _h_ += this.bagname.hashCode();
/* 928 */       _h_ += this.capacity;
/* 929 */       _h_ += this.items.hashCode();
/* 930 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 936 */       StringBuilder _sb_ = new StringBuilder();
/* 937 */       _sb_.append("(");
/* 938 */       _sb_.append("'").append(this.bagname).append("'");
/* 939 */       _sb_.append(",");
/* 940 */       _sb_.append(this.capacity);
/* 941 */       _sb_.append(",");
/* 942 */       _sb_.append(this.items);
/* 943 */       _sb_.append(")");
/* 944 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Bag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */