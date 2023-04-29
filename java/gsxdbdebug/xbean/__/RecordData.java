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
/*     */ public final class RecordData extends XBean implements xbean.RecordData
/*     */ {
/*     */   private HashMap<Long, xbean.RoleRankData> rankdatas;
/*     */   private long lastlogtime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.rankdatas.clear();
/*  21 */     this.lastlogtime = 0L;
/*     */   }
/*     */   
/*     */   RecordData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.rankdatas = new HashMap();
/*     */   }
/*     */   
/*     */   public RecordData()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RecordData(RecordData _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RecordData(xbean.RecordData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof RecordData)) { assign((RecordData)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RecordData _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.rankdatas = new HashMap();
/*  53 */     for (Map.Entry<Long, xbean.RoleRankData> _e_ : _o_.rankdatas.entrySet())
/*  54 */       this.rankdatas.put(_e_.getKey(), new RoleRankData((xbean.RoleRankData)_e_.getValue(), this, "rankdatas"));
/*  55 */     this.lastlogtime = _o_.lastlogtime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.rankdatas = new HashMap();
/*  61 */     for (Map.Entry<Long, xbean.RoleRankData> _e_ : _o_.rankdatas.entrySet())
/*  62 */       this.rankdatas.put(_e_.getKey(), new RoleRankData((xbean.RoleRankData)_e_.getValue(), this, "rankdatas"));
/*  63 */     this.lastlogtime = _o_.lastlogtime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.compact_uint32(this.rankdatas.size());
/*  71 */     for (Map.Entry<Long, xbean.RoleRankData> _e_ : this.rankdatas.entrySet())
/*     */     {
/*  73 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  74 */       ((xbean.RoleRankData)_e_.getValue()).marshal(_os_);
/*     */     }
/*  76 */     _os_.marshal(this.lastlogtime);
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
/*  88 */       this.rankdatas = new HashMap(size * 2);
/*     */     }
/*  90 */     for (; size > 0; size--)
/*     */     {
/*  92 */       long _k_ = 0L;
/*  93 */       _k_ = _os_.unmarshal_long();
/*  94 */       xbean.RoleRankData _v_ = new RoleRankData(0, this, "rankdatas");
/*  95 */       _v_.unmarshal(_os_);
/*  96 */       this.rankdatas.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*  99 */     this.lastlogtime = _os_.unmarshal_long();
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     for (Map.Entry<Long, xbean.RoleRankData> _e_ : this.rankdatas.entrySet())
/*     */     {
/* 110 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 111 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 113 */     _size_ += CodedOutputStream.computeInt64Size(3, this.lastlogtime);
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       for (Map.Entry<Long, xbean.RoleRankData> _e_ : this.rankdatas.entrySet())
/*     */       {
/* 125 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 126 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 128 */       _output_.writeInt64(3, this.lastlogtime);
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
/*     */         case 16: 
/* 156 */           long _k_ = 0L;
/* 157 */           _k_ = _input_.readInt64();
/* 158 */           int readTag = _input_.readTag();
/* 159 */           if (18 != readTag)
/*     */           {
/* 161 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 163 */           xbean.RoleRankData _v_ = new RoleRankData(0, this, "rankdatas");
/* 164 */           _input_.readMessage(_v_);
/* 165 */           this.rankdatas.put(Long.valueOf(_k_), _v_);
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 170 */           this.lastlogtime = _input_.readInt64();
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
/*     */   public xbean.RecordData copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new RecordData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RecordData toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RecordData toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new RecordData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RecordData toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RecordData toBeanIf()
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
/*     */   public Map<Long, xbean.RoleRankData> getRankdatas()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return xdb.Logs.logMap(new xdb.LogKey(this, "rankdatas"), this.rankdatas);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.RoleRankData> getRankdatasAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     RecordData _o_ = this;
/* 250 */     Map<Long, xbean.RoleRankData> rankdatas = new HashMap();
/* 251 */     for (Map.Entry<Long, xbean.RoleRankData> _e_ : _o_.rankdatas.entrySet())
/* 252 */       rankdatas.put(_e_.getKey(), new RoleRankData.Data((xbean.RoleRankData)_e_.getValue()));
/* 253 */     return rankdatas;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLastlogtime()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return this.lastlogtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLastlogtime(long _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "lastlogtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogLong(this, RecordData.this.lastlogtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             RecordData.this.lastlogtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.lastlogtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     RecordData _o_ = null;
/* 290 */     if ((_o1_ instanceof RecordData)) { _o_ = (RecordData)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (!this.rankdatas.equals(_o_.rankdatas)) return false;
/* 294 */     if (this.lastlogtime != _o_.lastlogtime) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ += this.rankdatas.hashCode();
/* 304 */     _h_ = (int)(_h_ + this.lastlogtime);
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.rankdatas);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.lastlogtime);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableMap().setVarName("rankdatas"));
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("lastlogtime"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RecordData {
/*     */     private Const() {}
/*     */     
/*     */     RecordData nThis() {
/* 334 */       return RecordData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RecordData copy()
/*     */     {
/* 346 */       return RecordData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RecordData toData()
/*     */     {
/* 352 */       return RecordData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RecordData toBean()
/*     */     {
/* 357 */       return RecordData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RecordData toDataIf()
/*     */     {
/* 363 */       return RecordData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RecordData toBeanIf()
/*     */     {
/* 368 */       return RecordData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.RoleRankData> getRankdatas()
/*     */     {
/* 375 */       RecordData.this._xdb_verify_unsafe_();
/* 376 */       return xdb.Consts.constMap(RecordData.this.rankdatas);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.RoleRankData> getRankdatasAsData()
/*     */     {
/* 383 */       RecordData.this._xdb_verify_unsafe_();
/*     */       
/* 385 */       RecordData _o_ = RecordData.this;
/* 386 */       Map<Long, xbean.RoleRankData> rankdatas = new HashMap();
/* 387 */       for (Map.Entry<Long, xbean.RoleRankData> _e_ : _o_.rankdatas.entrySet())
/* 388 */         rankdatas.put(_e_.getKey(), new RoleRankData.Data((xbean.RoleRankData)_e_.getValue()));
/* 389 */       return rankdatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLastlogtime()
/*     */     {
/* 396 */       RecordData.this._xdb_verify_unsafe_();
/* 397 */       return RecordData.this.lastlogtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastlogtime(long _v_)
/*     */     {
/* 404 */       RecordData.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       RecordData.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       RecordData.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return RecordData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return RecordData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       RecordData.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return RecordData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return RecordData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       RecordData.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return RecordData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return RecordData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return RecordData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return RecordData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return RecordData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return RecordData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return RecordData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RecordData
/*     */   {
/*     */     private HashMap<Long, xbean.RoleRankData> rankdatas;
/*     */     
/*     */     private long lastlogtime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.rankdatas = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.RecordData _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof RecordData)) { assign((RecordData)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof RecordData.Const)) assign(((RecordData.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RecordData _o_) {
/* 531 */       this.rankdatas = new HashMap();
/* 532 */       for (Map.Entry<Long, xbean.RoleRankData> _e_ : _o_.rankdatas.entrySet())
/* 533 */         this.rankdatas.put(_e_.getKey(), new RoleRankData.Data((xbean.RoleRankData)_e_.getValue()));
/* 534 */       this.lastlogtime = _o_.lastlogtime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 539 */       this.rankdatas = new HashMap();
/* 540 */       for (Map.Entry<Long, xbean.RoleRankData> _e_ : _o_.rankdatas.entrySet())
/* 541 */         this.rankdatas.put(_e_.getKey(), new RoleRankData.Data((xbean.RoleRankData)_e_.getValue()));
/* 542 */       this.lastlogtime = _o_.lastlogtime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.compact_uint32(this.rankdatas.size());
/* 549 */       for (Map.Entry<Long, xbean.RoleRankData> _e_ : this.rankdatas.entrySet())
/*     */       {
/* 551 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 552 */         ((xbean.RoleRankData)_e_.getValue()).marshal(_os_);
/*     */       }
/* 554 */       _os_.marshal(this.lastlogtime);
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
/* 565 */         this.rankdatas = new HashMap(size * 2);
/*     */       }
/* 567 */       for (; size > 0; size--)
/*     */       {
/* 569 */         long _k_ = 0L;
/* 570 */         _k_ = _os_.unmarshal_long();
/* 571 */         xbean.RoleRankData _v_ = xbean.Pod.newRoleRankDataData();
/* 572 */         _v_.unmarshal(_os_);
/* 573 */         this.rankdatas.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 576 */       this.lastlogtime = _os_.unmarshal_long();
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       for (Map.Entry<Long, xbean.RoleRankData> _e_ : this.rankdatas.entrySet())
/*     */       {
/* 586 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 587 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 589 */       _size_ += CodedOutputStream.computeInt64Size(3, this.lastlogtime);
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         for (Map.Entry<Long, xbean.RoleRankData> _e_ : this.rankdatas.entrySet())
/*     */         {
/* 600 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 601 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/* 603 */         _output_.writeInt64(3, this.lastlogtime);
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
/*     */           case 16: 
/* 630 */             long _k_ = 0L;
/* 631 */             _k_ = _input_.readInt64();
/* 632 */             int readTag = _input_.readTag();
/* 633 */             if (18 != readTag)
/*     */             {
/* 635 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 637 */             xbean.RoleRankData _v_ = xbean.Pod.newRoleRankDataData();
/* 638 */             _input_.readMessage(_v_);
/* 639 */             this.rankdatas.put(Long.valueOf(_k_), _v_);
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 644 */             this.lastlogtime = _input_.readInt64();
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
/*     */     public xbean.RecordData copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RecordData toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RecordData toBean()
/*     */     {
/* 683 */       return new RecordData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RecordData toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RecordData toBeanIf()
/*     */     {
/* 694 */       return new RecordData(this, null, null);
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
/*     */     public Map<Long, xbean.RoleRankData> getRankdatas()
/*     */     {
/* 731 */       return this.rankdatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.RoleRankData> getRankdatasAsData()
/*     */     {
/* 738 */       return this.rankdatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLastlogtime()
/*     */     {
/* 745 */       return this.lastlogtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastlogtime(long _v_)
/*     */     {
/* 752 */       this.lastlogtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (!this.rankdatas.equals(_o_.rankdatas)) return false;
/* 761 */       if (this.lastlogtime != _o_.lastlogtime) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ += this.rankdatas.hashCode();
/* 770 */       _h_ = (int)(_h_ + this.lastlogtime);
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.rankdatas);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.lastlogtime);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RecordData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */