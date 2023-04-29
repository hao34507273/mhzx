/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class FriendTotalInfo extends XBean implements xbean.FriendTotalInfo
/*     */ {
/*     */   private HashMap<Long, xbean.FriendInfo> friendinfomap;
/*     */   private long cleardatatime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.friendinfomap.clear();
/*  21 */     this.cleardatatime = 0L;
/*     */   }
/*     */   
/*     */   FriendTotalInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.friendinfomap = new HashMap();
/*     */   }
/*     */   
/*     */   public FriendTotalInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FriendTotalInfo(FriendTotalInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FriendTotalInfo(xbean.FriendTotalInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof FriendTotalInfo)) { assign((FriendTotalInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FriendTotalInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.friendinfomap = new HashMap();
/*  53 */     for (Map.Entry<Long, xbean.FriendInfo> _e_ : _o_.friendinfomap.entrySet())
/*  54 */       this.friendinfomap.put(_e_.getKey(), new FriendInfo((xbean.FriendInfo)_e_.getValue(), this, "friendinfomap"));
/*  55 */     this.cleardatatime = _o_.cleardatatime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.friendinfomap = new HashMap();
/*  61 */     for (Map.Entry<Long, xbean.FriendInfo> _e_ : _o_.friendinfomap.entrySet())
/*  62 */       this.friendinfomap.put(_e_.getKey(), new FriendInfo((xbean.FriendInfo)_e_.getValue(), this, "friendinfomap"));
/*  63 */     this.cleardatatime = _o_.cleardatatime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.compact_uint32(this.friendinfomap.size());
/*  71 */     for (Map.Entry<Long, xbean.FriendInfo> _e_ : this.friendinfomap.entrySet())
/*     */     {
/*  73 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  74 */       ((xbean.FriendInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  76 */     _os_.marshal(this.cleardatatime);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*     */     
/*  85 */     int size = _os_.uncompact_uint32();
/*  86 */     if (size >= 12)
/*     */     {
/*  88 */       this.friendinfomap = new HashMap(size * 2);
/*     */     }
/*  90 */     for (; size > 0; size--)
/*     */     {
/*  92 */       long _k_ = 0L;
/*  93 */       _k_ = _os_.unmarshal_long();
/*  94 */       xbean.FriendInfo _v_ = new FriendInfo(0, this, "friendinfomap");
/*  95 */       _v_.unmarshal(_os_);
/*  96 */       this.friendinfomap.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*  99 */     this.cleardatatime = _os_.unmarshal_long();
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     for (Map.Entry<Long, xbean.FriendInfo> _e_ : this.friendinfomap.entrySet())
/*     */     {
/* 110 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 111 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 113 */     _size_ += CodedOutputStream.computeInt64Size(2, this.cleardatatime);
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       for (Map.Entry<Long, xbean.FriendInfo> _e_ : this.friendinfomap.entrySet())
/*     */       {
/* 125 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 126 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 128 */       _output_.writeInt64(2, this.cleardatatime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 132 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 134 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 143 */       boolean done = false;
/* 144 */       while (!done)
/*     */       {
/* 146 */         int tag = _input_.readTag();
/* 147 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 151 */           done = true;
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 156 */           long _k_ = 0L;
/* 157 */           _k_ = _input_.readInt64();
/* 158 */           int readTag = _input_.readTag();
/* 159 */           if (10 != readTag)
/*     */           {
/* 161 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 163 */           xbean.FriendInfo _v_ = new FriendInfo(0, this, "friendinfomap");
/* 164 */           _input_.readMessage(_v_);
/* 165 */           this.friendinfomap.put(Long.valueOf(_k_), _v_);
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.cleardatatime = _input_.readInt64();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 175 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 177 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 186 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 190 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 192 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FriendTotalInfo copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new FriendTotalInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FriendTotalInfo toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FriendTotalInfo toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new FriendTotalInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FriendTotalInfo toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FriendTotalInfo toBeanIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.FriendInfo> getFriendinfomap()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return xdb.Logs.logMap(new xdb.LogKey(this, "friendinfomap"), this.friendinfomap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.FriendInfo> getFriendinfomapAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     FriendTotalInfo _o_ = this;
/* 250 */     Map<Long, xbean.FriendInfo> friendinfomap = new HashMap();
/* 251 */     for (Map.Entry<Long, xbean.FriendInfo> _e_ : _o_.friendinfomap.entrySet())
/* 252 */       friendinfomap.put(_e_.getKey(), new FriendInfo.Data((xbean.FriendInfo)_e_.getValue()));
/* 253 */     return friendinfomap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCleardatatime()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return this.cleardatatime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCleardatatime(long _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "cleardatatime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogLong(this, FriendTotalInfo.this.cleardatatime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             FriendTotalInfo.this.cleardatatime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.cleardatatime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     FriendTotalInfo _o_ = null;
/* 290 */     if ((_o1_ instanceof FriendTotalInfo)) { _o_ = (FriendTotalInfo)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (!this.friendinfomap.equals(_o_.friendinfomap)) return false;
/* 294 */     if (this.cleardatatime != _o_.cleardatatime) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ += this.friendinfomap.hashCode();
/* 304 */     _h_ = (int)(_h_ + this.cleardatatime);
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.friendinfomap);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.cleardatatime);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableMap().setVarName("friendinfomap"));
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("cleardatatime"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FriendTotalInfo {
/*     */     private Const() {}
/*     */     
/*     */     FriendTotalInfo nThis() {
/* 334 */       return FriendTotalInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FriendTotalInfo copy()
/*     */     {
/* 346 */       return FriendTotalInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FriendTotalInfo toData()
/*     */     {
/* 352 */       return FriendTotalInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FriendTotalInfo toBean()
/*     */     {
/* 357 */       return FriendTotalInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FriendTotalInfo toDataIf()
/*     */     {
/* 363 */       return FriendTotalInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FriendTotalInfo toBeanIf()
/*     */     {
/* 368 */       return FriendTotalInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FriendInfo> getFriendinfomap()
/*     */     {
/* 375 */       FriendTotalInfo.this._xdb_verify_unsafe_();
/* 376 */       return xdb.Consts.constMap(FriendTotalInfo.this.friendinfomap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FriendInfo> getFriendinfomapAsData()
/*     */     {
/* 383 */       FriendTotalInfo.this._xdb_verify_unsafe_();
/*     */       
/* 385 */       FriendTotalInfo _o_ = FriendTotalInfo.this;
/* 386 */       Map<Long, xbean.FriendInfo> friendinfomap = new HashMap();
/* 387 */       for (Map.Entry<Long, xbean.FriendInfo> _e_ : _o_.friendinfomap.entrySet())
/* 388 */         friendinfomap.put(_e_.getKey(), new FriendInfo.Data((xbean.FriendInfo)_e_.getValue()));
/* 389 */       return friendinfomap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCleardatatime()
/*     */     {
/* 396 */       FriendTotalInfo.this._xdb_verify_unsafe_();
/* 397 */       return FriendTotalInfo.this.cleardatatime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleardatatime(long _v_)
/*     */     {
/* 404 */       FriendTotalInfo.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       FriendTotalInfo.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       FriendTotalInfo.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return FriendTotalInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return FriendTotalInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       FriendTotalInfo.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return FriendTotalInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return FriendTotalInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       FriendTotalInfo.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return FriendTotalInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return FriendTotalInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return FriendTotalInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return FriendTotalInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return FriendTotalInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return FriendTotalInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return FriendTotalInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FriendTotalInfo
/*     */   {
/*     */     private HashMap<Long, xbean.FriendInfo> friendinfomap;
/*     */     
/*     */     private long cleardatatime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.friendinfomap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.FriendTotalInfo _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof FriendTotalInfo)) { assign((FriendTotalInfo)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof FriendTotalInfo.Const)) assign(((FriendTotalInfo.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FriendTotalInfo _o_) {
/* 531 */       this.friendinfomap = new HashMap();
/* 532 */       for (Map.Entry<Long, xbean.FriendInfo> _e_ : _o_.friendinfomap.entrySet())
/* 533 */         this.friendinfomap.put(_e_.getKey(), new FriendInfo.Data((xbean.FriendInfo)_e_.getValue()));
/* 534 */       this.cleardatatime = _o_.cleardatatime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 539 */       this.friendinfomap = new HashMap();
/* 540 */       for (Map.Entry<Long, xbean.FriendInfo> _e_ : _o_.friendinfomap.entrySet())
/* 541 */         this.friendinfomap.put(_e_.getKey(), new FriendInfo.Data((xbean.FriendInfo)_e_.getValue()));
/* 542 */       this.cleardatatime = _o_.cleardatatime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.compact_uint32(this.friendinfomap.size());
/* 549 */       for (Map.Entry<Long, xbean.FriendInfo> _e_ : this.friendinfomap.entrySet())
/*     */       {
/* 551 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 552 */         ((xbean.FriendInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 554 */       _os_.marshal(this.cleardatatime);
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 562 */       int size = _os_.uncompact_uint32();
/* 563 */       if (size >= 12)
/*     */       {
/* 565 */         this.friendinfomap = new HashMap(size * 2);
/*     */       }
/* 567 */       for (; size > 0; size--)
/*     */       {
/* 569 */         long _k_ = 0L;
/* 570 */         _k_ = _os_.unmarshal_long();
/* 571 */         xbean.FriendInfo _v_ = xbean.Pod.newFriendInfoData();
/* 572 */         _v_.unmarshal(_os_);
/* 573 */         this.friendinfomap.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 576 */       this.cleardatatime = _os_.unmarshal_long();
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       for (Map.Entry<Long, xbean.FriendInfo> _e_ : this.friendinfomap.entrySet())
/*     */       {
/* 586 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 587 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 589 */       _size_ += CodedOutputStream.computeInt64Size(2, this.cleardatatime);
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         for (Map.Entry<Long, xbean.FriendInfo> _e_ : this.friendinfomap.entrySet())
/*     */         {
/* 600 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 601 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 603 */         _output_.writeInt64(2, this.cleardatatime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 607 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 609 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 617 */         boolean done = false;
/* 618 */         while (!done)
/*     */         {
/* 620 */           int tag = _input_.readTag();
/* 621 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 625 */             done = true;
/* 626 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 630 */             long _k_ = 0L;
/* 631 */             _k_ = _input_.readInt64();
/* 632 */             int readTag = _input_.readTag();
/* 633 */             if (10 != readTag)
/*     */             {
/* 635 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 637 */             xbean.FriendInfo _v_ = xbean.Pod.newFriendInfoData();
/* 638 */             _input_.readMessage(_v_);
/* 639 */             this.friendinfomap.put(Long.valueOf(_k_), _v_);
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 644 */             this.cleardatatime = _input_.readInt64();
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FriendTotalInfo copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FriendTotalInfo toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FriendTotalInfo toBean()
/*     */     {
/* 683 */       return new FriendTotalInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FriendTotalInfo toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FriendTotalInfo toBeanIf()
/*     */     {
/* 694 */       return new FriendTotalInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FriendInfo> getFriendinfomap()
/*     */     {
/* 731 */       return this.friendinfomap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FriendInfo> getFriendinfomapAsData()
/*     */     {
/* 738 */       return this.friendinfomap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCleardatatime()
/*     */     {
/* 745 */       return this.cleardatatime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleardatatime(long _v_)
/*     */     {
/* 752 */       this.cleardatatime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (!this.friendinfomap.equals(_o_.friendinfomap)) return false;
/* 761 */       if (this.cleardatatime != _o_.cleardatatime) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ += this.friendinfomap.hashCode();
/* 770 */       _h_ = (int)(_h_ + this.cleardatatime);
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.friendinfomap);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.cleardatatime);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FriendTotalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */