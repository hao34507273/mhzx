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
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class WantedInfo extends XBean implements xbean.WantedInfo
/*     */ {
/*     */   private HashMap<Long, Integer> roleid2count;
/*     */   private int npcfightcount;
/*     */   private long starttimestamp;
/*     */   private long sessionid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.roleid2count.clear();
/*  25 */     this.npcfightcount = 0;
/*  26 */     this.starttimestamp = 0L;
/*  27 */     this.sessionid = 0L;
/*     */   }
/*     */   
/*     */   WantedInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.roleid2count = new HashMap();
/*     */   }
/*     */   
/*     */   public WantedInfo()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public WantedInfo(WantedInfo _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   WantedInfo(xbean.WantedInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof WantedInfo)) { assign((WantedInfo)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(WantedInfo _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.roleid2count = new HashMap();
/*  59 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2count.entrySet())
/*  60 */       this.roleid2count.put(_e_.getKey(), _e_.getValue());
/*  61 */     this.npcfightcount = _o_.npcfightcount;
/*  62 */     this.starttimestamp = _o_.starttimestamp;
/*  63 */     this.sessionid = _o_.sessionid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  68 */     this.roleid2count = new HashMap();
/*  69 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2count.entrySet())
/*  70 */       this.roleid2count.put(_e_.getKey(), _e_.getValue());
/*  71 */     this.npcfightcount = _o_.npcfightcount;
/*  72 */     this.starttimestamp = _o_.starttimestamp;
/*  73 */     this.sessionid = _o_.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.compact_uint32(this.roleid2count.size());
/*  81 */     for (Map.Entry<Long, Integer> _e_ : this.roleid2count.entrySet())
/*     */     {
/*  83 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  84 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  86 */     _os_.marshal(this.npcfightcount);
/*  87 */     _os_.marshal(this.starttimestamp);
/*  88 */     _os_.marshal(this.sessionid);
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*     */     
/*  97 */     int size = _os_.uncompact_uint32();
/*  98 */     if (size >= 12)
/*     */     {
/* 100 */       this.roleid2count = new HashMap(size * 2);
/*     */     }
/* 102 */     for (; size > 0; size--)
/*     */     {
/* 104 */       long _k_ = 0L;
/* 105 */       _k_ = _os_.unmarshal_long();
/* 106 */       int _v_ = 0;
/* 107 */       _v_ = _os_.unmarshal_int();
/* 108 */       this.roleid2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 111 */     this.npcfightcount = _os_.unmarshal_int();
/* 112 */     this.starttimestamp = _os_.unmarshal_long();
/* 113 */     this.sessionid = _os_.unmarshal_long();
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     int _size_ = 0;
/* 122 */     for (Map.Entry<Long, Integer> _e_ : this.roleid2count.entrySet())
/*     */     {
/* 124 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 125 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 127 */     _size_ += CodedOutputStream.computeInt32Size(2, this.npcfightcount);
/* 128 */     _size_ += CodedOutputStream.computeInt64Size(3, this.starttimestamp);
/* 129 */     _size_ += CodedOutputStream.computeInt64Size(4, this.sessionid);
/* 130 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 139 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2count.entrySet())
/*     */       {
/* 141 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 142 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 144 */       _output_.writeInt32(2, this.npcfightcount);
/* 145 */       _output_.writeInt64(3, this.starttimestamp);
/* 146 */       _output_.writeInt64(4, this.sessionid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 161 */       boolean done = false;
/* 162 */       while (!done)
/*     */       {
/* 164 */         int tag = _input_.readTag();
/* 165 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 169 */           done = true;
/* 170 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 174 */           long _k_ = 0L;
/* 175 */           _k_ = _input_.readInt64();
/* 176 */           int readTag = _input_.readTag();
/* 177 */           if (8 != readTag)
/*     */           {
/* 179 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 181 */           int _v_ = 0;
/* 182 */           _v_ = _input_.readInt32();
/* 183 */           this.roleid2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 184 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 188 */           this.npcfightcount = _input_.readInt32();
/* 189 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 193 */           this.starttimestamp = _input_.readInt64();
/* 194 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 198 */           this.sessionid = _input_.readInt64();
/* 199 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 203 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 205 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 214 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 218 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 220 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WantedInfo copy()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new WantedInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WantedInfo toData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WantedInfo toBean()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new WantedInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WantedInfo toDataIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WantedInfo toBeanIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getRoleid2count()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return xdb.Logs.logMap(new LogKey(this, "roleid2count"), this.roleid2count);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getRoleid2countAsData()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/*     */     
/* 277 */     WantedInfo _o_ = this;
/* 278 */     Map<Long, Integer> roleid2count = new HashMap();
/* 279 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2count.entrySet())
/* 280 */       roleid2count.put(_e_.getKey(), _e_.getValue());
/* 281 */     return roleid2count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNpcfightcount()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     return this.npcfightcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStarttimestamp()
/*     */   {
/* 296 */     _xdb_verify_unsafe_();
/* 297 */     return this.starttimestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionid()
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     return this.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNpcfightcount(int _v_)
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     xdb.Logs.logIf(new LogKey(this, "npcfightcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 317 */         new xdb.logs.LogInt(this, WantedInfo.this.npcfightcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 321 */             WantedInfo.this.npcfightcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 325 */     });
/* 326 */     this.npcfightcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStarttimestamp(long _v_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     xdb.Logs.logIf(new LogKey(this, "starttimestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 338 */         new xdb.logs.LogLong(this, WantedInfo.this.starttimestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 342 */             WantedInfo.this.starttimestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 346 */     });
/* 347 */     this.starttimestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionid(long _v_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     xdb.Logs.logIf(new LogKey(this, "sessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 359 */         new xdb.logs.LogLong(this, WantedInfo.this.sessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 363 */             WantedInfo.this.sessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 367 */     });
/* 368 */     this.sessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 374 */     _xdb_verify_unsafe_();
/* 375 */     WantedInfo _o_ = null;
/* 376 */     if ((_o1_ instanceof WantedInfo)) { _o_ = (WantedInfo)_o1_;
/* 377 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 378 */       return false;
/* 379 */     if (!this.roleid2count.equals(_o_.roleid2count)) return false;
/* 380 */     if (this.npcfightcount != _o_.npcfightcount) return false;
/* 381 */     if (this.starttimestamp != _o_.starttimestamp) return false;
/* 382 */     if (this.sessionid != _o_.sessionid) return false;
/* 383 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     int _h_ = 0;
/* 391 */     _h_ += this.roleid2count.hashCode();
/* 392 */     _h_ += this.npcfightcount;
/* 393 */     _h_ = (int)(_h_ + this.starttimestamp);
/* 394 */     _h_ = (int)(_h_ + this.sessionid);
/* 395 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 401 */     _xdb_verify_unsafe_();
/* 402 */     StringBuilder _sb_ = new StringBuilder();
/* 403 */     _sb_.append("(");
/* 404 */     _sb_.append(this.roleid2count);
/* 405 */     _sb_.append(",");
/* 406 */     _sb_.append(this.npcfightcount);
/* 407 */     _sb_.append(",");
/* 408 */     _sb_.append(this.starttimestamp);
/* 409 */     _sb_.append(",");
/* 410 */     _sb_.append(this.sessionid);
/* 411 */     _sb_.append(")");
/* 412 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 418 */     ListenableBean lb = new ListenableBean();
/* 419 */     lb.add(new xdb.logs.ListenableMap().setVarName("roleid2count"));
/* 420 */     lb.add(new xdb.logs.ListenableChanged().setVarName("npcfightcount"));
/* 421 */     lb.add(new xdb.logs.ListenableChanged().setVarName("starttimestamp"));
/* 422 */     lb.add(new xdb.logs.ListenableChanged().setVarName("sessionid"));
/* 423 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.WantedInfo {
/*     */     private Const() {}
/*     */     
/*     */     WantedInfo nThis() {
/* 430 */       return WantedInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WantedInfo copy()
/*     */     {
/* 442 */       return WantedInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WantedInfo toData()
/*     */     {
/* 448 */       return WantedInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.WantedInfo toBean()
/*     */     {
/* 453 */       return WantedInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WantedInfo toDataIf()
/*     */     {
/* 459 */       return WantedInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.WantedInfo toBeanIf()
/*     */     {
/* 464 */       return WantedInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRoleid2count()
/*     */     {
/* 471 */       WantedInfo.this._xdb_verify_unsafe_();
/* 472 */       return xdb.Consts.constMap(WantedInfo.this.roleid2count);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRoleid2countAsData()
/*     */     {
/* 479 */       WantedInfo.this._xdb_verify_unsafe_();
/*     */       
/* 481 */       WantedInfo _o_ = WantedInfo.this;
/* 482 */       Map<Long, Integer> roleid2count = new HashMap();
/* 483 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2count.entrySet())
/* 484 */         roleid2count.put(_e_.getKey(), _e_.getValue());
/* 485 */       return roleid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNpcfightcount()
/*     */     {
/* 492 */       WantedInfo.this._xdb_verify_unsafe_();
/* 493 */       return WantedInfo.this.npcfightcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttimestamp()
/*     */     {
/* 500 */       WantedInfo.this._xdb_verify_unsafe_();
/* 501 */       return WantedInfo.this.starttimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 508 */       WantedInfo.this._xdb_verify_unsafe_();
/* 509 */       return WantedInfo.this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNpcfightcount(int _v_)
/*     */     {
/* 516 */       WantedInfo.this._xdb_verify_unsafe_();
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttimestamp(long _v_)
/*     */     {
/* 524 */       WantedInfo.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 532 */       WantedInfo.this._xdb_verify_unsafe_();
/* 533 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 539 */       WantedInfo.this._xdb_verify_unsafe_();
/* 540 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 546 */       WantedInfo.this._xdb_verify_unsafe_();
/* 547 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 553 */       return WantedInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 559 */       return WantedInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 565 */       WantedInfo.this._xdb_verify_unsafe_();
/* 566 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 572 */       return WantedInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 578 */       return WantedInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 584 */       WantedInfo.this._xdb_verify_unsafe_();
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 591 */       return WantedInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 597 */       return WantedInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 603 */       return WantedInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 609 */       return WantedInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 615 */       return WantedInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 621 */       return WantedInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 627 */       return WantedInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.WantedInfo
/*     */   {
/*     */     private HashMap<Long, Integer> roleid2count;
/*     */     
/*     */     private int npcfightcount;
/*     */     
/*     */     private long starttimestamp;
/*     */     
/*     */     private long sessionid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 645 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 650 */       this.roleid2count = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.WantedInfo _o1_)
/*     */     {
/* 655 */       if ((_o1_ instanceof WantedInfo)) { assign((WantedInfo)_o1_);
/* 656 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 657 */       } else if ((_o1_ instanceof WantedInfo.Const)) assign(((WantedInfo.Const)_o1_).nThis()); else {
/* 658 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(WantedInfo _o_) {
/* 663 */       this.roleid2count = new HashMap();
/* 664 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2count.entrySet())
/* 665 */         this.roleid2count.put(_e_.getKey(), _e_.getValue());
/* 666 */       this.npcfightcount = _o_.npcfightcount;
/* 667 */       this.starttimestamp = _o_.starttimestamp;
/* 668 */       this.sessionid = _o_.sessionid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 673 */       this.roleid2count = new HashMap();
/* 674 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2count.entrySet())
/* 675 */         this.roleid2count.put(_e_.getKey(), _e_.getValue());
/* 676 */       this.npcfightcount = _o_.npcfightcount;
/* 677 */       this.starttimestamp = _o_.starttimestamp;
/* 678 */       this.sessionid = _o_.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 684 */       _os_.compact_uint32(this.roleid2count.size());
/* 685 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2count.entrySet())
/*     */       {
/* 687 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 688 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 690 */       _os_.marshal(this.npcfightcount);
/* 691 */       _os_.marshal(this.starttimestamp);
/* 692 */       _os_.marshal(this.sessionid);
/* 693 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 700 */       int size = _os_.uncompact_uint32();
/* 701 */       if (size >= 12)
/*     */       {
/* 703 */         this.roleid2count = new HashMap(size * 2);
/*     */       }
/* 705 */       for (; size > 0; size--)
/*     */       {
/* 707 */         long _k_ = 0L;
/* 708 */         _k_ = _os_.unmarshal_long();
/* 709 */         int _v_ = 0;
/* 710 */         _v_ = _os_.unmarshal_int();
/* 711 */         this.roleid2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 714 */       this.npcfightcount = _os_.unmarshal_int();
/* 715 */       this.starttimestamp = _os_.unmarshal_long();
/* 716 */       this.sessionid = _os_.unmarshal_long();
/* 717 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 723 */       int _size_ = 0;
/* 724 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2count.entrySet())
/*     */       {
/* 726 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 727 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 729 */       _size_ += CodedOutputStream.computeInt32Size(2, this.npcfightcount);
/* 730 */       _size_ += CodedOutputStream.computeInt64Size(3, this.starttimestamp);
/* 731 */       _size_ += CodedOutputStream.computeInt64Size(4, this.sessionid);
/* 732 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 740 */         for (Map.Entry<Long, Integer> _e_ : this.roleid2count.entrySet())
/*     */         {
/* 742 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 743 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 745 */         _output_.writeInt32(2, this.npcfightcount);
/* 746 */         _output_.writeInt64(3, this.starttimestamp);
/* 747 */         _output_.writeInt64(4, this.sessionid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 751 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 753 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 761 */         boolean done = false;
/* 762 */         while (!done)
/*     */         {
/* 764 */           int tag = _input_.readTag();
/* 765 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 769 */             done = true;
/* 770 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 774 */             long _k_ = 0L;
/* 775 */             _k_ = _input_.readInt64();
/* 776 */             int readTag = _input_.readTag();
/* 777 */             if (8 != readTag)
/*     */             {
/* 779 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 781 */             int _v_ = 0;
/* 782 */             _v_ = _input_.readInt32();
/* 783 */             this.roleid2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 784 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 788 */             this.npcfightcount = _input_.readInt32();
/* 789 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 793 */             this.starttimestamp = _input_.readInt64();
/* 794 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 798 */             this.sessionid = _input_.readInt64();
/* 799 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 803 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 805 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 814 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 818 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 820 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WantedInfo copy()
/*     */     {
/* 826 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WantedInfo toData()
/*     */     {
/* 832 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.WantedInfo toBean()
/*     */     {
/* 837 */       return new WantedInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WantedInfo toDataIf()
/*     */     {
/* 843 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.WantedInfo toBeanIf()
/*     */     {
/* 848 */       return new WantedInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 854 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 858 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 862 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 866 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 874 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 878 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRoleid2count()
/*     */     {
/* 885 */       return this.roleid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRoleid2countAsData()
/*     */     {
/* 892 */       return this.roleid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNpcfightcount()
/*     */     {
/* 899 */       return this.npcfightcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttimestamp()
/*     */     {
/* 906 */       return this.starttimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 913 */       return this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNpcfightcount(int _v_)
/*     */     {
/* 920 */       this.npcfightcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttimestamp(long _v_)
/*     */     {
/* 927 */       this.starttimestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 934 */       this.sessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 940 */       if (!(_o1_ instanceof Data)) return false;
/* 941 */       Data _o_ = (Data)_o1_;
/* 942 */       if (!this.roleid2count.equals(_o_.roleid2count)) return false;
/* 943 */       if (this.npcfightcount != _o_.npcfightcount) return false;
/* 944 */       if (this.starttimestamp != _o_.starttimestamp) return false;
/* 945 */       if (this.sessionid != _o_.sessionid) return false;
/* 946 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 952 */       int _h_ = 0;
/* 953 */       _h_ += this.roleid2count.hashCode();
/* 954 */       _h_ += this.npcfightcount;
/* 955 */       _h_ = (int)(_h_ + this.starttimestamp);
/* 956 */       _h_ = (int)(_h_ + this.sessionid);
/* 957 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 963 */       StringBuilder _sb_ = new StringBuilder();
/* 964 */       _sb_.append("(");
/* 965 */       _sb_.append(this.roleid2count);
/* 966 */       _sb_.append(",");
/* 967 */       _sb_.append(this.npcfightcount);
/* 968 */       _sb_.append(",");
/* 969 */       _sb_.append(this.starttimestamp);
/* 970 */       _sb_.append(",");
/* 971 */       _sb_.append(this.sessionid);
/* 972 */       _sb_.append(")");
/* 973 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WantedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */