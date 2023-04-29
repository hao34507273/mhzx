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
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class ShoppingInfo extends XBean implements xbean.ShoppingInfo
/*     */ {
/*     */   private int totalnum;
/*     */   private xbean.Item item;
/*     */   private long roleid;
/*     */   private int price;
/*     */   private long expire;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.totalnum = 0;
/*  27 */     this.item._reset_unsafe_();
/*  28 */     this.roleid = 0L;
/*  29 */     this.price = 0;
/*  30 */     this.expire = 0L;
/*     */   }
/*     */   
/*     */   ShoppingInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.item = new Item(0, this, "item");
/*     */   }
/*     */   
/*     */   public ShoppingInfo()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ShoppingInfo(ShoppingInfo _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ShoppingInfo(xbean.ShoppingInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     if ((_o1_ instanceof ShoppingInfo)) { assign((ShoppingInfo)_o1_);
/*  53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  55 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ShoppingInfo _o_) {
/*  60 */     _o_._xdb_verify_unsafe_();
/*  61 */     this.totalnum = _o_.totalnum;
/*  62 */     this.item = new Item(_o_.item, this, "item");
/*  63 */     this.roleid = _o_.roleid;
/*  64 */     this.price = _o_.price;
/*  65 */     this.expire = _o_.expire;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  70 */     this.totalnum = _o_.totalnum;
/*  71 */     this.item = new Item(_o_.item, this, "item");
/*  72 */     this.roleid = _o_.roleid;
/*  73 */     this.price = _o_.price;
/*  74 */     this.expire = _o_.expire;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     _os_.marshal(this.totalnum);
/*  82 */     this.item.marshal(_os_);
/*  83 */     _os_.marshal(this.roleid);
/*  84 */     _os_.marshal(this.price);
/*  85 */     _os_.marshal(this.expire);
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     this.totalnum = _os_.unmarshal_int();
/*  94 */     this.item.unmarshal(_os_);
/*  95 */     this.roleid = _os_.unmarshal_long();
/*  96 */     this.price = _os_.unmarshal_int();
/*  97 */     this.expire = _os_.unmarshal_long();
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 104 */     _xdb_verify_unsafe_();
/* 105 */     int _size_ = 0;
/* 106 */     _size_ += CodedOutputStream.computeInt32Size(1, this.totalnum);
/* 107 */     _size_ += CodedOutputStream.computeMessageSize(2, this.item);
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(3, this.roleid);
/* 109 */     _size_ += CodedOutputStream.computeInt32Size(4, this.price);
/* 110 */     _size_ += CodedOutputStream.computeInt64Size(5, this.expire);
/* 111 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       _output_.writeInt32(1, this.totalnum);
/* 121 */       _output_.writeMessage(2, this.item);
/* 122 */       _output_.writeInt64(3, this.roleid);
/* 123 */       _output_.writeInt32(4, this.price);
/* 124 */       _output_.writeInt64(5, this.expire);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 128 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 130 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 139 */       boolean done = false;
/* 140 */       while (!done)
/*     */       {
/* 142 */         int tag = _input_.readTag();
/* 143 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 147 */           done = true;
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 152 */           this.totalnum = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 157 */           _input_.readMessage(this.item);
/* 158 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 162 */           this.roleid = _input_.readInt64();
/* 163 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 167 */           this.price = _input_.readInt32();
/* 168 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 172 */           this.expire = _input_.readInt64();
/* 173 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 177 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 179 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 188 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 192 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 194 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ShoppingInfo copy()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new ShoppingInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ShoppingInfo toData()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ShoppingInfo toBean()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new ShoppingInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ShoppingInfo toDataIf()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ShoppingInfo toBeanIf()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTotalnum()
/*     */   {
/* 241 */     _xdb_verify_unsafe_();
/* 242 */     return this.totalnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.Item getItem()
/*     */   {
/* 249 */     _xdb_verify_unsafe_();
/* 250 */     return this.item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPrice()
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     return this.price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getExpire()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return this.expire;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalnum(int _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "totalnum")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 286 */         new xdb.logs.LogInt(this, ShoppingInfo.this.totalnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             ShoppingInfo.this.totalnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.totalnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid(long _v_)
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 307 */         new LogLong(this, ShoppingInfo.this.roleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 311 */             ShoppingInfo.this.roleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 315 */     });
/* 316 */     this.roleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPrice(int _v_)
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     xdb.Logs.logIf(new LogKey(this, "price")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 328 */         new xdb.logs.LogInt(this, ShoppingInfo.this.price)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 332 */             ShoppingInfo.this.price = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 336 */     });
/* 337 */     this.price = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExpire(long _v_)
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     xdb.Logs.logIf(new LogKey(this, "expire")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 349 */         new LogLong(this, ShoppingInfo.this.expire)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 353 */             ShoppingInfo.this.expire = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 357 */     });
/* 358 */     this.expire = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     ShoppingInfo _o_ = null;
/* 366 */     if ((_o1_ instanceof ShoppingInfo)) { _o_ = (ShoppingInfo)_o1_;
/* 367 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 368 */       return false;
/* 369 */     if (this.totalnum != _o_.totalnum) return false;
/* 370 */     if (!this.item.equals(_o_.item)) return false;
/* 371 */     if (this.roleid != _o_.roleid) return false;
/* 372 */     if (this.price != _o_.price) return false;
/* 373 */     if (this.expire != _o_.expire) return false;
/* 374 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 380 */     _xdb_verify_unsafe_();
/* 381 */     int _h_ = 0;
/* 382 */     _h_ += this.totalnum;
/* 383 */     _h_ += this.item.hashCode();
/* 384 */     _h_ = (int)(_h_ + this.roleid);
/* 385 */     _h_ += this.price;
/* 386 */     _h_ = (int)(_h_ + this.expire);
/* 387 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 393 */     _xdb_verify_unsafe_();
/* 394 */     StringBuilder _sb_ = new StringBuilder();
/* 395 */     _sb_.append("(");
/* 396 */     _sb_.append(this.totalnum);
/* 397 */     _sb_.append(",");
/* 398 */     _sb_.append(this.item);
/* 399 */     _sb_.append(",");
/* 400 */     _sb_.append(this.roleid);
/* 401 */     _sb_.append(",");
/* 402 */     _sb_.append(this.price);
/* 403 */     _sb_.append(",");
/* 404 */     _sb_.append(this.expire);
/* 405 */     _sb_.append(")");
/* 406 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 412 */     ListenableBean lb = new ListenableBean();
/* 413 */     lb.add(new ListenableChanged().setVarName("totalnum"));
/* 414 */     lb.add(new ListenableChanged().setVarName("item"));
/* 415 */     lb.add(new ListenableChanged().setVarName("roleid"));
/* 416 */     lb.add(new ListenableChanged().setVarName("price"));
/* 417 */     lb.add(new ListenableChanged().setVarName("expire"));
/* 418 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ShoppingInfo {
/*     */     private Const() {}
/*     */     
/*     */     ShoppingInfo nThis() {
/* 425 */       return ShoppingInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingInfo copy()
/*     */     {
/* 437 */       return ShoppingInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingInfo toData()
/*     */     {
/* 443 */       return ShoppingInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ShoppingInfo toBean()
/*     */     {
/* 448 */       return ShoppingInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingInfo toDataIf()
/*     */     {
/* 454 */       return ShoppingInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ShoppingInfo toBeanIf()
/*     */     {
/* 459 */       return ShoppingInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalnum()
/*     */     {
/* 466 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 467 */       return ShoppingInfo.this.totalnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.Item getItem()
/*     */     {
/* 474 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 475 */       return (xbean.Item)xdb.Consts.toConst(ShoppingInfo.this.item);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 482 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 483 */       return ShoppingInfo.this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPrice()
/*     */     {
/* 490 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 491 */       return ShoppingInfo.this.price;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExpire()
/*     */     {
/* 498 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 499 */       return ShoppingInfo.this.expire;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalnum(int _v_)
/*     */     {
/* 506 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 514 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPrice(int _v_)
/*     */     {
/* 522 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 523 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpire(long _v_)
/*     */     {
/* 530 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 531 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 537 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 538 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 544 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 545 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 551 */       return ShoppingInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 557 */       return ShoppingInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 563 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 564 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 570 */       return ShoppingInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 576 */       return ShoppingInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 582 */       ShoppingInfo.this._xdb_verify_unsafe_();
/* 583 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 589 */       return ShoppingInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 595 */       return ShoppingInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 601 */       return ShoppingInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 607 */       return ShoppingInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 613 */       return ShoppingInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 619 */       return ShoppingInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 625 */       return ShoppingInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ShoppingInfo
/*     */   {
/*     */     private int totalnum;
/*     */     
/*     */     private xbean.Item item;
/*     */     
/*     */     private long roleid;
/*     */     
/*     */     private int price;
/*     */     
/*     */     private long expire;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 645 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 650 */       this.item = new Item.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.ShoppingInfo _o1_)
/*     */     {
/* 655 */       if ((_o1_ instanceof ShoppingInfo)) { assign((ShoppingInfo)_o1_);
/* 656 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 657 */       } else if ((_o1_ instanceof ShoppingInfo.Const)) assign(((ShoppingInfo.Const)_o1_).nThis()); else {
/* 658 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ShoppingInfo _o_) {
/* 663 */       this.totalnum = _o_.totalnum;
/* 664 */       this.item = new Item.Data(_o_.item);
/* 665 */       this.roleid = _o_.roleid;
/* 666 */       this.price = _o_.price;
/* 667 */       this.expire = _o_.expire;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 672 */       this.totalnum = _o_.totalnum;
/* 673 */       this.item = new Item.Data(_o_.item);
/* 674 */       this.roleid = _o_.roleid;
/* 675 */       this.price = _o_.price;
/* 676 */       this.expire = _o_.expire;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 682 */       _os_.marshal(this.totalnum);
/* 683 */       this.item.marshal(_os_);
/* 684 */       _os_.marshal(this.roleid);
/* 685 */       _os_.marshal(this.price);
/* 686 */       _os_.marshal(this.expire);
/* 687 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 693 */       this.totalnum = _os_.unmarshal_int();
/* 694 */       this.item.unmarshal(_os_);
/* 695 */       this.roleid = _os_.unmarshal_long();
/* 696 */       this.price = _os_.unmarshal_int();
/* 697 */       this.expire = _os_.unmarshal_long();
/* 698 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 704 */       int _size_ = 0;
/* 705 */       _size_ += CodedOutputStream.computeInt32Size(1, this.totalnum);
/* 706 */       _size_ += CodedOutputStream.computeMessageSize(2, this.item);
/* 707 */       _size_ += CodedOutputStream.computeInt64Size(3, this.roleid);
/* 708 */       _size_ += CodedOutputStream.computeInt32Size(4, this.price);
/* 709 */       _size_ += CodedOutputStream.computeInt64Size(5, this.expire);
/* 710 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 718 */         _output_.writeInt32(1, this.totalnum);
/* 719 */         _output_.writeMessage(2, this.item);
/* 720 */         _output_.writeInt64(3, this.roleid);
/* 721 */         _output_.writeInt32(4, this.price);
/* 722 */         _output_.writeInt64(5, this.expire);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 726 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 728 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 736 */         boolean done = false;
/* 737 */         while (!done)
/*     */         {
/* 739 */           int tag = _input_.readTag();
/* 740 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 744 */             done = true;
/* 745 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 749 */             this.totalnum = _input_.readInt32();
/* 750 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 754 */             _input_.readMessage(this.item);
/* 755 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 759 */             this.roleid = _input_.readInt64();
/* 760 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 764 */             this.price = _input_.readInt32();
/* 765 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 769 */             this.expire = _input_.readInt64();
/* 770 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 774 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 776 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 785 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 789 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 791 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingInfo copy()
/*     */     {
/* 797 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingInfo toData()
/*     */     {
/* 803 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ShoppingInfo toBean()
/*     */     {
/* 808 */       return new ShoppingInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShoppingInfo toDataIf()
/*     */     {
/* 814 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ShoppingInfo toBeanIf()
/*     */     {
/* 819 */       return new ShoppingInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 825 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 829 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 833 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 837 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 841 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 845 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 849 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalnum()
/*     */     {
/* 856 */       return this.totalnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.Item getItem()
/*     */     {
/* 863 */       return this.item;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 870 */       return this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPrice()
/*     */     {
/* 877 */       return this.price;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExpire()
/*     */     {
/* 884 */       return this.expire;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalnum(int _v_)
/*     */     {
/* 891 */       this.totalnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 898 */       this.roleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPrice(int _v_)
/*     */     {
/* 905 */       this.price = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpire(long _v_)
/*     */     {
/* 912 */       this.expire = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 918 */       if (!(_o1_ instanceof Data)) return false;
/* 919 */       Data _o_ = (Data)_o1_;
/* 920 */       if (this.totalnum != _o_.totalnum) return false;
/* 921 */       if (!this.item.equals(_o_.item)) return false;
/* 922 */       if (this.roleid != _o_.roleid) return false;
/* 923 */       if (this.price != _o_.price) return false;
/* 924 */       if (this.expire != _o_.expire) return false;
/* 925 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 931 */       int _h_ = 0;
/* 932 */       _h_ += this.totalnum;
/* 933 */       _h_ += this.item.hashCode();
/* 934 */       _h_ = (int)(_h_ + this.roleid);
/* 935 */       _h_ += this.price;
/* 936 */       _h_ = (int)(_h_ + this.expire);
/* 937 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 943 */       StringBuilder _sb_ = new StringBuilder();
/* 944 */       _sb_.append("(");
/* 945 */       _sb_.append(this.totalnum);
/* 946 */       _sb_.append(",");
/* 947 */       _sb_.append(this.item);
/* 948 */       _sb_.append(",");
/* 949 */       _sb_.append(this.roleid);
/* 950 */       _sb_.append(",");
/* 951 */       _sb_.append(this.price);
/* 952 */       _sb_.append(",");
/* 953 */       _sb_.append(this.expire);
/* 954 */       _sb_.append(")");
/* 955 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ShoppingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */