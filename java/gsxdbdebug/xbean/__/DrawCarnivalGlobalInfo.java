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
/*     */ public final class DrawCarnivalGlobalInfo extends XBean implements xbean.DrawCarnivalGlobalInfo
/*     */ {
/*     */   private long award_pool_yuan_bao_count;
/*     */   private HashMap<Integer, xbean.DrawCarnivalActivityInfo> activity_id2info;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.award_pool_yuan_bao_count = 0L;
/*  21 */     this.activity_id2info.clear();
/*     */   }
/*     */   
/*     */   DrawCarnivalGlobalInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.activity_id2info = new HashMap();
/*     */   }
/*     */   
/*     */   public DrawCarnivalGlobalInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public DrawCarnivalGlobalInfo(DrawCarnivalGlobalInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   DrawCarnivalGlobalInfo(xbean.DrawCarnivalGlobalInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof DrawCarnivalGlobalInfo)) { assign((DrawCarnivalGlobalInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(DrawCarnivalGlobalInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.award_pool_yuan_bao_count = _o_.award_pool_yuan_bao_count;
/*  53 */     this.activity_id2info = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : _o_.activity_id2info.entrySet()) {
/*  55 */       this.activity_id2info.put(_e_.getKey(), new DrawCarnivalActivityInfo((xbean.DrawCarnivalActivityInfo)_e_.getValue(), this, "activity_id2info"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  60 */     this.award_pool_yuan_bao_count = _o_.award_pool_yuan_bao_count;
/*  61 */     this.activity_id2info = new HashMap();
/*  62 */     for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : _o_.activity_id2info.entrySet()) {
/*  63 */       this.activity_id2info.put(_e_.getKey(), new DrawCarnivalActivityInfo((xbean.DrawCarnivalActivityInfo)_e_.getValue(), this, "activity_id2info"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.award_pool_yuan_bao_count);
/*  71 */     _os_.compact_uint32(this.activity_id2info.size());
/*  72 */     for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : this.activity_id2info.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  75 */       ((xbean.DrawCarnivalActivityInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     this.award_pool_yuan_bao_count = _os_.unmarshal_long();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.activity_id2info = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       int _k_ = 0;
/*  94 */       _k_ = _os_.unmarshal_int();
/*  95 */       xbean.DrawCarnivalActivityInfo _v_ = new DrawCarnivalActivityInfo(0, this, "activity_id2info");
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.activity_id2info.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(1, this.award_pool_yuan_bao_count);
/* 109 */     for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : this.activity_id2info.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 112 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       _output_.writeInt64(1, this.award_pool_yuan_bao_count);
/* 124 */       for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : this.activity_id2info.entrySet())
/*     */       {
/* 126 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 127 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
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
/* 156 */           this.award_pool_yuan_bao_count = _input_.readInt64();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 161 */           int _k_ = 0;
/* 162 */           _k_ = _input_.readInt32();
/* 163 */           int readTag = _input_.readTag();
/* 164 */           if (18 != readTag)
/*     */           {
/* 166 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 168 */           xbean.DrawCarnivalActivityInfo _v_ = new DrawCarnivalActivityInfo(0, this, "activity_id2info");
/* 169 */           _input_.readMessage(_v_);
/* 170 */           this.activity_id2info.put(Integer.valueOf(_k_), _v_);
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
/*     */   public xbean.DrawCarnivalGlobalInfo copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new DrawCarnivalGlobalInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DrawCarnivalGlobalInfo toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DrawCarnivalGlobalInfo toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new DrawCarnivalGlobalInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DrawCarnivalGlobalInfo toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DrawCarnivalGlobalInfo toBeanIf()
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
/*     */   public long getAward_pool_yuan_bao_count()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this.award_pool_yuan_bao_count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.DrawCarnivalActivityInfo> getActivity_id2info()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return xdb.Logs.logMap(new xdb.LogKey(this, "activity_id2info"), this.activity_id2info);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.DrawCarnivalActivityInfo> getActivity_id2infoAsData()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/*     */     
/* 257 */     DrawCarnivalGlobalInfo _o_ = this;
/* 258 */     Map<Integer, xbean.DrawCarnivalActivityInfo> activity_id2info = new HashMap();
/* 259 */     for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : _o_.activity_id2info.entrySet())
/* 260 */       activity_id2info.put(_e_.getKey(), new DrawCarnivalActivityInfo.Data((xbean.DrawCarnivalActivityInfo)_e_.getValue()));
/* 261 */     return activity_id2info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAward_pool_yuan_bao_count(long _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "award_pool_yuan_bao_count")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogLong(this, DrawCarnivalGlobalInfo.this.award_pool_yuan_bao_count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             DrawCarnivalGlobalInfo.this.award_pool_yuan_bao_count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.award_pool_yuan_bao_count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     DrawCarnivalGlobalInfo _o_ = null;
/* 290 */     if ((_o1_ instanceof DrawCarnivalGlobalInfo)) { _o_ = (DrawCarnivalGlobalInfo)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (this.award_pool_yuan_bao_count != _o_.award_pool_yuan_bao_count) return false;
/* 294 */     if (!this.activity_id2info.equals(_o_.activity_id2info)) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ = (int)(_h_ + this.award_pool_yuan_bao_count);
/* 304 */     _h_ += this.activity_id2info.hashCode();
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.award_pool_yuan_bao_count);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.activity_id2info);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableChanged().setVarName("award_pool_yuan_bao_count"));
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("activity_id2info"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.DrawCarnivalGlobalInfo {
/*     */     private Const() {}
/*     */     
/*     */     DrawCarnivalGlobalInfo nThis() {
/* 334 */       return DrawCarnivalGlobalInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawCarnivalGlobalInfo copy()
/*     */     {
/* 346 */       return DrawCarnivalGlobalInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawCarnivalGlobalInfo toData()
/*     */     {
/* 352 */       return DrawCarnivalGlobalInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.DrawCarnivalGlobalInfo toBean()
/*     */     {
/* 357 */       return DrawCarnivalGlobalInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawCarnivalGlobalInfo toDataIf()
/*     */     {
/* 363 */       return DrawCarnivalGlobalInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.DrawCarnivalGlobalInfo toBeanIf()
/*     */     {
/* 368 */       return DrawCarnivalGlobalInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAward_pool_yuan_bao_count()
/*     */     {
/* 375 */       DrawCarnivalGlobalInfo.this._xdb_verify_unsafe_();
/* 376 */       return DrawCarnivalGlobalInfo.this.award_pool_yuan_bao_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.DrawCarnivalActivityInfo> getActivity_id2info()
/*     */     {
/* 383 */       DrawCarnivalGlobalInfo.this._xdb_verify_unsafe_();
/* 384 */       return xdb.Consts.constMap(DrawCarnivalGlobalInfo.this.activity_id2info);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.DrawCarnivalActivityInfo> getActivity_id2infoAsData()
/*     */     {
/* 391 */       DrawCarnivalGlobalInfo.this._xdb_verify_unsafe_();
/*     */       
/* 393 */       DrawCarnivalGlobalInfo _o_ = DrawCarnivalGlobalInfo.this;
/* 394 */       Map<Integer, xbean.DrawCarnivalActivityInfo> activity_id2info = new HashMap();
/* 395 */       for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : _o_.activity_id2info.entrySet())
/* 396 */         activity_id2info.put(_e_.getKey(), new DrawCarnivalActivityInfo.Data((xbean.DrawCarnivalActivityInfo)_e_.getValue()));
/* 397 */       return activity_id2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_pool_yuan_bao_count(long _v_)
/*     */     {
/* 404 */       DrawCarnivalGlobalInfo.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       DrawCarnivalGlobalInfo.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       DrawCarnivalGlobalInfo.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return DrawCarnivalGlobalInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return DrawCarnivalGlobalInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       DrawCarnivalGlobalInfo.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return DrawCarnivalGlobalInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return DrawCarnivalGlobalInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       DrawCarnivalGlobalInfo.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return DrawCarnivalGlobalInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return DrawCarnivalGlobalInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return DrawCarnivalGlobalInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return DrawCarnivalGlobalInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return DrawCarnivalGlobalInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return DrawCarnivalGlobalInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return DrawCarnivalGlobalInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.DrawCarnivalGlobalInfo
/*     */   {
/*     */     private long award_pool_yuan_bao_count;
/*     */     
/*     */     private HashMap<Integer, xbean.DrawCarnivalActivityInfo> activity_id2info;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.activity_id2info = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.DrawCarnivalGlobalInfo _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof DrawCarnivalGlobalInfo)) { assign((DrawCarnivalGlobalInfo)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof DrawCarnivalGlobalInfo.Const)) assign(((DrawCarnivalGlobalInfo.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(DrawCarnivalGlobalInfo _o_) {
/* 531 */       this.award_pool_yuan_bao_count = _o_.award_pool_yuan_bao_count;
/* 532 */       this.activity_id2info = new HashMap();
/* 533 */       for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : _o_.activity_id2info.entrySet()) {
/* 534 */         this.activity_id2info.put(_e_.getKey(), new DrawCarnivalActivityInfo.Data((xbean.DrawCarnivalActivityInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 539 */       this.award_pool_yuan_bao_count = _o_.award_pool_yuan_bao_count;
/* 540 */       this.activity_id2info = new HashMap();
/* 541 */       for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : _o_.activity_id2info.entrySet()) {
/* 542 */         this.activity_id2info.put(_e_.getKey(), new DrawCarnivalActivityInfo.Data((xbean.DrawCarnivalActivityInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.marshal(this.award_pool_yuan_bao_count);
/* 549 */       _os_.compact_uint32(this.activity_id2info.size());
/* 550 */       for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : this.activity_id2info.entrySet())
/*     */       {
/* 552 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 553 */         ((xbean.DrawCarnivalActivityInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 561 */       this.award_pool_yuan_bao_count = _os_.unmarshal_long();
/*     */       
/* 563 */       int size = _os_.uncompact_uint32();
/* 564 */       if (size >= 12)
/*     */       {
/* 566 */         this.activity_id2info = new HashMap(size * 2);
/*     */       }
/* 568 */       for (; size > 0; size--)
/*     */       {
/* 570 */         int _k_ = 0;
/* 571 */         _k_ = _os_.unmarshal_int();
/* 572 */         xbean.DrawCarnivalActivityInfo _v_ = xbean.Pod.newDrawCarnivalActivityInfoData();
/* 573 */         _v_.unmarshal(_os_);
/* 574 */         this.activity_id2info.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       _size_ += CodedOutputStream.computeInt64Size(1, this.award_pool_yuan_bao_count);
/* 585 */       for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : this.activity_id2info.entrySet())
/*     */       {
/* 587 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 588 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         _output_.writeInt64(1, this.award_pool_yuan_bao_count);
/* 599 */         for (Map.Entry<Integer, xbean.DrawCarnivalActivityInfo> _e_ : this.activity_id2info.entrySet())
/*     */         {
/* 601 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 602 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
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
/* 630 */             this.award_pool_yuan_bao_count = _input_.readInt64();
/* 631 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 635 */             int _k_ = 0;
/* 636 */             _k_ = _input_.readInt32();
/* 637 */             int readTag = _input_.readTag();
/* 638 */             if (18 != readTag)
/*     */             {
/* 640 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 642 */             xbean.DrawCarnivalActivityInfo _v_ = xbean.Pod.newDrawCarnivalActivityInfoData();
/* 643 */             _input_.readMessage(_v_);
/* 644 */             this.activity_id2info.put(Integer.valueOf(_k_), _v_);
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
/*     */     public xbean.DrawCarnivalGlobalInfo copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawCarnivalGlobalInfo toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.DrawCarnivalGlobalInfo toBean()
/*     */     {
/* 683 */       return new DrawCarnivalGlobalInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawCarnivalGlobalInfo toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.DrawCarnivalGlobalInfo toBeanIf()
/*     */     {
/* 694 */       return new DrawCarnivalGlobalInfo(this, null, null);
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
/*     */     public long getAward_pool_yuan_bao_count()
/*     */     {
/* 731 */       return this.award_pool_yuan_bao_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.DrawCarnivalActivityInfo> getActivity_id2info()
/*     */     {
/* 738 */       return this.activity_id2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.DrawCarnivalActivityInfo> getActivity_id2infoAsData()
/*     */     {
/* 745 */       return this.activity_id2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_pool_yuan_bao_count(long _v_)
/*     */     {
/* 752 */       this.award_pool_yuan_bao_count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (this.award_pool_yuan_bao_count != _o_.award_pool_yuan_bao_count) return false;
/* 761 */       if (!this.activity_id2info.equals(_o_.activity_id2info)) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ = (int)(_h_ + this.award_pool_yuan_bao_count);
/* 770 */       _h_ += this.activity_id2info.hashCode();
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.award_pool_yuan_bao_count);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.activity_id2info);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DrawCarnivalGlobalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */