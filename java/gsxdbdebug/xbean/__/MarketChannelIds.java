/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class MarketChannelIds extends XBean implements xbean.MarketChannelIds
/*     */ {
/*     */   private LinkedList<Long> channel_ids;
/*     */   private int supply_num;
/*     */   private long supply_time;
/*     */   private int supply_skill_equip_num;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.channel_ids.clear();
/*  25 */     this.supply_num = 0;
/*  26 */     this.supply_time = 0L;
/*  27 */     this.supply_skill_equip_num = 0;
/*     */   }
/*     */   
/*     */   MarketChannelIds(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.channel_ids = new LinkedList();
/*     */   }
/*     */   
/*     */   public MarketChannelIds()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MarketChannelIds(MarketChannelIds _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MarketChannelIds(xbean.MarketChannelIds _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof MarketChannelIds)) { assign((MarketChannelIds)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MarketChannelIds _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.channel_ids = new LinkedList();
/*  59 */     this.channel_ids.addAll(_o_.channel_ids);
/*  60 */     this.supply_num = _o_.supply_num;
/*  61 */     this.supply_time = _o_.supply_time;
/*  62 */     this.supply_skill_equip_num = _o_.supply_skill_equip_num;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.channel_ids = new LinkedList();
/*  68 */     this.channel_ids.addAll(_o_.channel_ids);
/*  69 */     this.supply_num = _o_.supply_num;
/*  70 */     this.supply_time = _o_.supply_time;
/*  71 */     this.supply_skill_equip_num = _o_.supply_skill_equip_num;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.compact_uint32(this.channel_ids.size());
/*  79 */     for (Long _v_ : this.channel_ids)
/*     */     {
/*  81 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  83 */     _os_.marshal(this.supply_num);
/*  84 */     _os_.marshal(this.supply_time);
/*  85 */     _os_.marshal(this.supply_skill_equip_num);
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  95 */       long _v_ = 0L;
/*  96 */       _v_ = _os_.unmarshal_long();
/*  97 */       this.channel_ids.add(Long.valueOf(_v_));
/*     */     }
/*  99 */     this.supply_num = _os_.unmarshal_int();
/* 100 */     this.supply_time = _os_.unmarshal_long();
/* 101 */     this.supply_skill_equip_num = _os_.unmarshal_int();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     for (Long _v_ : this.channel_ids)
/*     */     {
/* 112 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/* 114 */     _size_ += CodedOutputStream.computeInt32Size(2, this.supply_num);
/* 115 */     _size_ += CodedOutputStream.computeInt64Size(3, this.supply_time);
/* 116 */     _size_ += CodedOutputStream.computeInt32Size(4, this.supply_skill_equip_num);
/* 117 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 123 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 126 */       for (Long _v_ : this.channel_ids)
/*     */       {
/* 128 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/* 130 */       _output_.writeInt32(2, this.supply_num);
/* 131 */       _output_.writeInt64(3, this.supply_time);
/* 132 */       _output_.writeInt32(4, this.supply_skill_equip_num);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 138 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 147 */       boolean done = false;
/* 148 */       while (!done)
/*     */       {
/* 150 */         int tag = _input_.readTag();
/* 151 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 155 */           done = true;
/* 156 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 160 */           long _v_ = 0L;
/* 161 */           _v_ = _input_.readInt64();
/* 162 */           this.channel_ids.add(Long.valueOf(_v_));
/* 163 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 167 */           this.supply_num = _input_.readInt32();
/* 168 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 172 */           this.supply_time = _input_.readInt64();
/* 173 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 177 */           this.supply_skill_equip_num = _input_.readInt32();
/* 178 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 182 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 184 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 193 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 197 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 199 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarketChannelIds copy()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new MarketChannelIds(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarketChannelIds toData()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarketChannelIds toBean()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new MarketChannelIds(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarketChannelIds toDataIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarketChannelIds toBeanIf()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getChannel_ids()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return xdb.Logs.logList(new LogKey(this, "channel_ids"), this.channel_ids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getChannel_idsAsData()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/*     */     
/* 255 */     MarketChannelIds _o_ = this;
/* 256 */     List<Long> channel_ids = new LinkedList();
/* 257 */     channel_ids.addAll(_o_.channel_ids);
/* 258 */     return channel_ids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSupply_num()
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     return this.supply_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSupply_time()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return this.supply_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSupply_skill_equip_num()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     return this.supply_skill_equip_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSupply_num(int _v_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     xdb.Logs.logIf(new LogKey(this, "supply_num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 294 */         new xdb.logs.LogInt(this, MarketChannelIds.this.supply_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 298 */             MarketChannelIds.this.supply_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 302 */     });
/* 303 */     this.supply_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSupply_time(long _v_)
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/* 311 */     xdb.Logs.logIf(new LogKey(this, "supply_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 315 */         new xdb.logs.LogLong(this, MarketChannelIds.this.supply_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 319 */             MarketChannelIds.this.supply_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 323 */     });
/* 324 */     this.supply_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSupply_skill_equip_num(int _v_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     xdb.Logs.logIf(new LogKey(this, "supply_skill_equip_num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 336 */         new xdb.logs.LogInt(this, MarketChannelIds.this.supply_skill_equip_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 340 */             MarketChannelIds.this.supply_skill_equip_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 344 */     });
/* 345 */     this.supply_skill_equip_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 351 */     _xdb_verify_unsafe_();
/* 352 */     MarketChannelIds _o_ = null;
/* 353 */     if ((_o1_ instanceof MarketChannelIds)) { _o_ = (MarketChannelIds)_o1_;
/* 354 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 355 */       return false;
/* 356 */     if (!this.channel_ids.equals(_o_.channel_ids)) return false;
/* 357 */     if (this.supply_num != _o_.supply_num) return false;
/* 358 */     if (this.supply_time != _o_.supply_time) return false;
/* 359 */     if (this.supply_skill_equip_num != _o_.supply_skill_equip_num) return false;
/* 360 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 366 */     _xdb_verify_unsafe_();
/* 367 */     int _h_ = 0;
/* 368 */     _h_ += this.channel_ids.hashCode();
/* 369 */     _h_ += this.supply_num;
/* 370 */     _h_ = (int)(_h_ + this.supply_time);
/* 371 */     _h_ += this.supply_skill_equip_num;
/* 372 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     StringBuilder _sb_ = new StringBuilder();
/* 380 */     _sb_.append("(");
/* 381 */     _sb_.append(this.channel_ids);
/* 382 */     _sb_.append(",");
/* 383 */     _sb_.append(this.supply_num);
/* 384 */     _sb_.append(",");
/* 385 */     _sb_.append(this.supply_time);
/* 386 */     _sb_.append(",");
/* 387 */     _sb_.append(this.supply_skill_equip_num);
/* 388 */     _sb_.append(")");
/* 389 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 395 */     ListenableBean lb = new ListenableBean();
/* 396 */     lb.add(new ListenableChanged().setVarName("channel_ids"));
/* 397 */     lb.add(new ListenableChanged().setVarName("supply_num"));
/* 398 */     lb.add(new ListenableChanged().setVarName("supply_time"));
/* 399 */     lb.add(new ListenableChanged().setVarName("supply_skill_equip_num"));
/* 400 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MarketChannelIds {
/*     */     private Const() {}
/*     */     
/*     */     MarketChannelIds nThis() {
/* 407 */       return MarketChannelIds.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketChannelIds copy()
/*     */     {
/* 419 */       return MarketChannelIds.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketChannelIds toData()
/*     */     {
/* 425 */       return MarketChannelIds.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MarketChannelIds toBean()
/*     */     {
/* 430 */       return MarketChannelIds.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketChannelIds toDataIf()
/*     */     {
/* 436 */       return MarketChannelIds.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MarketChannelIds toBeanIf()
/*     */     {
/* 441 */       return MarketChannelIds.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getChannel_ids()
/*     */     {
/* 448 */       MarketChannelIds.this._xdb_verify_unsafe_();
/* 449 */       return xdb.Consts.constList(MarketChannelIds.this.channel_ids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getChannel_idsAsData()
/*     */     {
/* 455 */       MarketChannelIds.this._xdb_verify_unsafe_();
/*     */       
/* 457 */       MarketChannelIds _o_ = MarketChannelIds.this;
/* 458 */       List<Long> channel_ids = new LinkedList();
/* 459 */       channel_ids.addAll(_o_.channel_ids);
/* 460 */       return channel_ids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSupply_num()
/*     */     {
/* 467 */       MarketChannelIds.this._xdb_verify_unsafe_();
/* 468 */       return MarketChannelIds.this.supply_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSupply_time()
/*     */     {
/* 475 */       MarketChannelIds.this._xdb_verify_unsafe_();
/* 476 */       return MarketChannelIds.this.supply_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSupply_skill_equip_num()
/*     */     {
/* 483 */       MarketChannelIds.this._xdb_verify_unsafe_();
/* 484 */       return MarketChannelIds.this.supply_skill_equip_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSupply_num(int _v_)
/*     */     {
/* 491 */       MarketChannelIds.this._xdb_verify_unsafe_();
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSupply_time(long _v_)
/*     */     {
/* 499 */       MarketChannelIds.this._xdb_verify_unsafe_();
/* 500 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSupply_skill_equip_num(int _v_)
/*     */     {
/* 507 */       MarketChannelIds.this._xdb_verify_unsafe_();
/* 508 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 514 */       MarketChannelIds.this._xdb_verify_unsafe_();
/* 515 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 521 */       MarketChannelIds.this._xdb_verify_unsafe_();
/* 522 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 528 */       return MarketChannelIds.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 534 */       return MarketChannelIds.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 540 */       MarketChannelIds.this._xdb_verify_unsafe_();
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 547 */       return MarketChannelIds.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 553 */       return MarketChannelIds.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 559 */       MarketChannelIds.this._xdb_verify_unsafe_();
/* 560 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 566 */       return MarketChannelIds.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 572 */       return MarketChannelIds.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 578 */       return MarketChannelIds.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 584 */       return MarketChannelIds.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 590 */       return MarketChannelIds.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 596 */       return MarketChannelIds.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 602 */       return MarketChannelIds.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MarketChannelIds
/*     */   {
/*     */     private LinkedList<Long> channel_ids;
/*     */     
/*     */     private int supply_num;
/*     */     
/*     */     private long supply_time;
/*     */     
/*     */     private int supply_skill_equip_num;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 620 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 625 */       this.channel_ids = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.MarketChannelIds _o1_)
/*     */     {
/* 630 */       if ((_o1_ instanceof MarketChannelIds)) { assign((MarketChannelIds)_o1_);
/* 631 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 632 */       } else if ((_o1_ instanceof MarketChannelIds.Const)) assign(((MarketChannelIds.Const)_o1_).nThis()); else {
/* 633 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MarketChannelIds _o_) {
/* 638 */       this.channel_ids = new LinkedList();
/* 639 */       this.channel_ids.addAll(_o_.channel_ids);
/* 640 */       this.supply_num = _o_.supply_num;
/* 641 */       this.supply_time = _o_.supply_time;
/* 642 */       this.supply_skill_equip_num = _o_.supply_skill_equip_num;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 647 */       this.channel_ids = new LinkedList();
/* 648 */       this.channel_ids.addAll(_o_.channel_ids);
/* 649 */       this.supply_num = _o_.supply_num;
/* 650 */       this.supply_time = _o_.supply_time;
/* 651 */       this.supply_skill_equip_num = _o_.supply_skill_equip_num;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 657 */       _os_.compact_uint32(this.channel_ids.size());
/* 658 */       for (Long _v_ : this.channel_ids)
/*     */       {
/* 660 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 662 */       _os_.marshal(this.supply_num);
/* 663 */       _os_.marshal(this.supply_time);
/* 664 */       _os_.marshal(this.supply_skill_equip_num);
/* 665 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 671 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 673 */         long _v_ = 0L;
/* 674 */         _v_ = _os_.unmarshal_long();
/* 675 */         this.channel_ids.add(Long.valueOf(_v_));
/*     */       }
/* 677 */       this.supply_num = _os_.unmarshal_int();
/* 678 */       this.supply_time = _os_.unmarshal_long();
/* 679 */       this.supply_skill_equip_num = _os_.unmarshal_int();
/* 680 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 686 */       int _size_ = 0;
/* 687 */       for (Long _v_ : this.channel_ids)
/*     */       {
/* 689 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 691 */       _size_ += CodedOutputStream.computeInt32Size(2, this.supply_num);
/* 692 */       _size_ += CodedOutputStream.computeInt64Size(3, this.supply_time);
/* 693 */       _size_ += CodedOutputStream.computeInt32Size(4, this.supply_skill_equip_num);
/* 694 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 702 */         for (Long _v_ : this.channel_ids)
/*     */         {
/* 704 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/* 706 */         _output_.writeInt32(2, this.supply_num);
/* 707 */         _output_.writeInt64(3, this.supply_time);
/* 708 */         _output_.writeInt32(4, this.supply_skill_equip_num);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 712 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 714 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 722 */         boolean done = false;
/* 723 */         while (!done)
/*     */         {
/* 725 */           int tag = _input_.readTag();
/* 726 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 730 */             done = true;
/* 731 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 735 */             long _v_ = 0L;
/* 736 */             _v_ = _input_.readInt64();
/* 737 */             this.channel_ids.add(Long.valueOf(_v_));
/* 738 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 742 */             this.supply_num = _input_.readInt32();
/* 743 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 747 */             this.supply_time = _input_.readInt64();
/* 748 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 752 */             this.supply_skill_equip_num = _input_.readInt32();
/* 753 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 757 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 759 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 768 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 772 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 774 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketChannelIds copy()
/*     */     {
/* 780 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketChannelIds toData()
/*     */     {
/* 786 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MarketChannelIds toBean()
/*     */     {
/* 791 */       return new MarketChannelIds(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketChannelIds toDataIf()
/*     */     {
/* 797 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MarketChannelIds toBeanIf()
/*     */     {
/* 802 */       return new MarketChannelIds(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 808 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 812 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 816 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 820 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 824 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 828 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 832 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getChannel_ids()
/*     */     {
/* 839 */       return this.channel_ids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getChannel_idsAsData()
/*     */     {
/* 846 */       return this.channel_ids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSupply_num()
/*     */     {
/* 853 */       return this.supply_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSupply_time()
/*     */     {
/* 860 */       return this.supply_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSupply_skill_equip_num()
/*     */     {
/* 867 */       return this.supply_skill_equip_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSupply_num(int _v_)
/*     */     {
/* 874 */       this.supply_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSupply_time(long _v_)
/*     */     {
/* 881 */       this.supply_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSupply_skill_equip_num(int _v_)
/*     */     {
/* 888 */       this.supply_skill_equip_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 894 */       if (!(_o1_ instanceof Data)) return false;
/* 895 */       Data _o_ = (Data)_o1_;
/* 896 */       if (!this.channel_ids.equals(_o_.channel_ids)) return false;
/* 897 */       if (this.supply_num != _o_.supply_num) return false;
/* 898 */       if (this.supply_time != _o_.supply_time) return false;
/* 899 */       if (this.supply_skill_equip_num != _o_.supply_skill_equip_num) return false;
/* 900 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 906 */       int _h_ = 0;
/* 907 */       _h_ += this.channel_ids.hashCode();
/* 908 */       _h_ += this.supply_num;
/* 909 */       _h_ = (int)(_h_ + this.supply_time);
/* 910 */       _h_ += this.supply_skill_equip_num;
/* 911 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 917 */       StringBuilder _sb_ = new StringBuilder();
/* 918 */       _sb_.append("(");
/* 919 */       _sb_.append(this.channel_ids);
/* 920 */       _sb_.append(",");
/* 921 */       _sb_.append(this.supply_num);
/* 922 */       _sb_.append(",");
/* 923 */       _sb_.append(this.supply_time);
/* 924 */       _sb_.append(",");
/* 925 */       _sb_.append(this.supply_skill_equip_num);
/* 926 */       _sb_.append(")");
/* 927 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MarketChannelIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */