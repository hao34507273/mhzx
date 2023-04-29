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
/*     */ 
/*     */ public final class MenPaiStarCampaignInfo extends XBean implements xbean.MenPaiStarCampaignInfo
/*     */ {
/*     */   private int today_campaign_num;
/*     */   private long last_campaign_time;
/*     */   private HashMap<Integer, xbean.Campaign> campaigns;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.today_campaign_num = 0;
/*  23 */     this.last_campaign_time = 0L;
/*  24 */     this.campaigns.clear();
/*     */   }
/*     */   
/*     */   MenPaiStarCampaignInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.campaigns = new HashMap();
/*     */   }
/*     */   
/*     */   public MenPaiStarCampaignInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MenPaiStarCampaignInfo(MenPaiStarCampaignInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MenPaiStarCampaignInfo(xbean.MenPaiStarCampaignInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof MenPaiStarCampaignInfo)) { assign((MenPaiStarCampaignInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MenPaiStarCampaignInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.today_campaign_num = _o_.today_campaign_num;
/*  56 */     this.last_campaign_time = _o_.last_campaign_time;
/*  57 */     this.campaigns = new HashMap();
/*  58 */     for (Map.Entry<Integer, xbean.Campaign> _e_ : _o_.campaigns.entrySet()) {
/*  59 */       this.campaigns.put(_e_.getKey(), new Campaign((xbean.Campaign)_e_.getValue(), this, "campaigns"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  64 */     this.today_campaign_num = _o_.today_campaign_num;
/*  65 */     this.last_campaign_time = _o_.last_campaign_time;
/*  66 */     this.campaigns = new HashMap();
/*  67 */     for (Map.Entry<Integer, xbean.Campaign> _e_ : _o_.campaigns.entrySet()) {
/*  68 */       this.campaigns.put(_e_.getKey(), new Campaign((xbean.Campaign)_e_.getValue(), this, "campaigns"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.today_campaign_num);
/*  76 */     _os_.marshal(this.last_campaign_time);
/*  77 */     _os_.compact_uint32(this.campaigns.size());
/*  78 */     for (Map.Entry<Integer, xbean.Campaign> _e_ : this.campaigns.entrySet())
/*     */     {
/*  80 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  81 */       ((xbean.Campaign)_e_.getValue()).marshal(_os_);
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this.today_campaign_num = _os_.unmarshal_int();
/*  91 */     this.last_campaign_time = _os_.unmarshal_long();
/*     */     
/*  93 */     int size = _os_.uncompact_uint32();
/*  94 */     if (size >= 12)
/*     */     {
/*  96 */       this.campaigns = new HashMap(size * 2);
/*     */     }
/*  98 */     for (; size > 0; size--)
/*     */     {
/* 100 */       int _k_ = 0;
/* 101 */       _k_ = _os_.unmarshal_int();
/* 102 */       xbean.Campaign _v_ = new Campaign(0, this, "campaigns");
/* 103 */       _v_.unmarshal(_os_);
/* 104 */       this.campaigns.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     int _size_ = 0;
/* 115 */     _size_ += CodedOutputStream.computeInt32Size(1, this.today_campaign_num);
/* 116 */     _size_ += CodedOutputStream.computeInt64Size(2, this.last_campaign_time);
/* 117 */     for (Map.Entry<Integer, xbean.Campaign> _e_ : this.campaigns.entrySet())
/*     */     {
/* 119 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 120 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */     }
/* 122 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       _output_.writeInt32(1, this.today_campaign_num);
/* 132 */       _output_.writeInt64(2, this.last_campaign_time);
/* 133 */       for (Map.Entry<Integer, xbean.Campaign> _e_ : this.campaigns.entrySet())
/*     */       {
/* 135 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 136 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 141 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 143 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 149 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 152 */       boolean done = false;
/* 153 */       while (!done)
/*     */       {
/* 155 */         int tag = _input_.readTag();
/* 156 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 160 */           done = true;
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 165 */           this.today_campaign_num = _input_.readInt32();
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.last_campaign_time = _input_.readInt64();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 175 */           int _k_ = 0;
/* 176 */           _k_ = _input_.readInt32();
/* 177 */           int readTag = _input_.readTag();
/* 178 */           if (26 != readTag)
/*     */           {
/* 180 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 182 */           xbean.Campaign _v_ = new Campaign(0, this, "campaigns");
/* 183 */           _input_.readMessage(_v_);
/* 184 */           this.campaigns.put(Integer.valueOf(_k_), _v_);
/* 185 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 189 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 191 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 200 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 204 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 206 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MenPaiStarCampaignInfo copy()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new MenPaiStarCampaignInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MenPaiStarCampaignInfo toData()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MenPaiStarCampaignInfo toBean()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new MenPaiStarCampaignInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MenPaiStarCampaignInfo toDataIf()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MenPaiStarCampaignInfo toBeanIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getToday_campaign_num()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.today_campaign_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLast_campaign_time()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.last_campaign_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.Campaign> getCampaigns()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return xdb.Logs.logMap(new LogKey(this, "campaigns"), this.campaigns);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.Campaign> getCampaignsAsData()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/*     */     
/* 279 */     MenPaiStarCampaignInfo _o_ = this;
/* 280 */     Map<Integer, xbean.Campaign> campaigns = new HashMap();
/* 281 */     for (Map.Entry<Integer, xbean.Campaign> _e_ : _o_.campaigns.entrySet())
/* 282 */       campaigns.put(_e_.getKey(), new Campaign.Data((xbean.Campaign)_e_.getValue()));
/* 283 */     return campaigns;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setToday_campaign_num(int _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "today_campaign_num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogInt(this, MenPaiStarCampaignInfo.this.today_campaign_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             MenPaiStarCampaignInfo.this.today_campaign_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.today_campaign_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLast_campaign_time(long _v_)
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     xdb.Logs.logIf(new LogKey(this, "last_campaign_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 316 */         new xdb.logs.LogLong(this, MenPaiStarCampaignInfo.this.last_campaign_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 320 */             MenPaiStarCampaignInfo.this.last_campaign_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 324 */     });
/* 325 */     this.last_campaign_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     MenPaiStarCampaignInfo _o_ = null;
/* 333 */     if ((_o1_ instanceof MenPaiStarCampaignInfo)) { _o_ = (MenPaiStarCampaignInfo)_o1_;
/* 334 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 335 */       return false;
/* 336 */     if (this.today_campaign_num != _o_.today_campaign_num) return false;
/* 337 */     if (this.last_campaign_time != _o_.last_campaign_time) return false;
/* 338 */     if (!this.campaigns.equals(_o_.campaigns)) return false;
/* 339 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     int _h_ = 0;
/* 347 */     _h_ += this.today_campaign_num;
/* 348 */     _h_ = (int)(_h_ + this.last_campaign_time);
/* 349 */     _h_ += this.campaigns.hashCode();
/* 350 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     StringBuilder _sb_ = new StringBuilder();
/* 358 */     _sb_.append("(");
/* 359 */     _sb_.append(this.today_campaign_num);
/* 360 */     _sb_.append(",");
/* 361 */     _sb_.append(this.last_campaign_time);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this.campaigns);
/* 364 */     _sb_.append(")");
/* 365 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 371 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 372 */     lb.add(new xdb.logs.ListenableChanged().setVarName("today_campaign_num"));
/* 373 */     lb.add(new xdb.logs.ListenableChanged().setVarName("last_campaign_time"));
/* 374 */     lb.add(new xdb.logs.ListenableMap().setVarName("campaigns"));
/* 375 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MenPaiStarCampaignInfo {
/*     */     private Const() {}
/*     */     
/*     */     MenPaiStarCampaignInfo nThis() {
/* 382 */       return MenPaiStarCampaignInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 388 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarCampaignInfo copy()
/*     */     {
/* 394 */       return MenPaiStarCampaignInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarCampaignInfo toData()
/*     */     {
/* 400 */       return MenPaiStarCampaignInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MenPaiStarCampaignInfo toBean()
/*     */     {
/* 405 */       return MenPaiStarCampaignInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarCampaignInfo toDataIf()
/*     */     {
/* 411 */       return MenPaiStarCampaignInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MenPaiStarCampaignInfo toBeanIf()
/*     */     {
/* 416 */       return MenPaiStarCampaignInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getToday_campaign_num()
/*     */     {
/* 423 */       MenPaiStarCampaignInfo.this._xdb_verify_unsafe_();
/* 424 */       return MenPaiStarCampaignInfo.this.today_campaign_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_campaign_time()
/*     */     {
/* 431 */       MenPaiStarCampaignInfo.this._xdb_verify_unsafe_();
/* 432 */       return MenPaiStarCampaignInfo.this.last_campaign_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Campaign> getCampaigns()
/*     */     {
/* 439 */       MenPaiStarCampaignInfo.this._xdb_verify_unsafe_();
/* 440 */       return xdb.Consts.constMap(MenPaiStarCampaignInfo.this.campaigns);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Campaign> getCampaignsAsData()
/*     */     {
/* 447 */       MenPaiStarCampaignInfo.this._xdb_verify_unsafe_();
/*     */       
/* 449 */       MenPaiStarCampaignInfo _o_ = MenPaiStarCampaignInfo.this;
/* 450 */       Map<Integer, xbean.Campaign> campaigns = new HashMap();
/* 451 */       for (Map.Entry<Integer, xbean.Campaign> _e_ : _o_.campaigns.entrySet())
/* 452 */         campaigns.put(_e_.getKey(), new Campaign.Data((xbean.Campaign)_e_.getValue()));
/* 453 */       return campaigns;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_campaign_num(int _v_)
/*     */     {
/* 460 */       MenPaiStarCampaignInfo.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_campaign_time(long _v_)
/*     */     {
/* 468 */       MenPaiStarCampaignInfo.this._xdb_verify_unsafe_();
/* 469 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 475 */       MenPaiStarCampaignInfo.this._xdb_verify_unsafe_();
/* 476 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 482 */       MenPaiStarCampaignInfo.this._xdb_verify_unsafe_();
/* 483 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 489 */       return MenPaiStarCampaignInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 495 */       return MenPaiStarCampaignInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 501 */       MenPaiStarCampaignInfo.this._xdb_verify_unsafe_();
/* 502 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 508 */       return MenPaiStarCampaignInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 514 */       return MenPaiStarCampaignInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 520 */       MenPaiStarCampaignInfo.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 527 */       return MenPaiStarCampaignInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 533 */       return MenPaiStarCampaignInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 539 */       return MenPaiStarCampaignInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 545 */       return MenPaiStarCampaignInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 551 */       return MenPaiStarCampaignInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 557 */       return MenPaiStarCampaignInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 563 */       return MenPaiStarCampaignInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MenPaiStarCampaignInfo
/*     */   {
/*     */     private int today_campaign_num;
/*     */     
/*     */     private long last_campaign_time;
/*     */     
/*     */     private HashMap<Integer, xbean.Campaign> campaigns;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 579 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 584 */       this.campaigns = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.MenPaiStarCampaignInfo _o1_)
/*     */     {
/* 589 */       if ((_o1_ instanceof MenPaiStarCampaignInfo)) { assign((MenPaiStarCampaignInfo)_o1_);
/* 590 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 591 */       } else if ((_o1_ instanceof MenPaiStarCampaignInfo.Const)) assign(((MenPaiStarCampaignInfo.Const)_o1_).nThis()); else {
/* 592 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MenPaiStarCampaignInfo _o_) {
/* 597 */       this.today_campaign_num = _o_.today_campaign_num;
/* 598 */       this.last_campaign_time = _o_.last_campaign_time;
/* 599 */       this.campaigns = new HashMap();
/* 600 */       for (Map.Entry<Integer, xbean.Campaign> _e_ : _o_.campaigns.entrySet()) {
/* 601 */         this.campaigns.put(_e_.getKey(), new Campaign.Data((xbean.Campaign)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 606 */       this.today_campaign_num = _o_.today_campaign_num;
/* 607 */       this.last_campaign_time = _o_.last_campaign_time;
/* 608 */       this.campaigns = new HashMap();
/* 609 */       for (Map.Entry<Integer, xbean.Campaign> _e_ : _o_.campaigns.entrySet()) {
/* 610 */         this.campaigns.put(_e_.getKey(), new Campaign.Data((xbean.Campaign)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.marshal(this.today_campaign_num);
/* 617 */       _os_.marshal(this.last_campaign_time);
/* 618 */       _os_.compact_uint32(this.campaigns.size());
/* 619 */       for (Map.Entry<Integer, xbean.Campaign> _e_ : this.campaigns.entrySet())
/*     */       {
/* 621 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 622 */         ((xbean.Campaign)_e_.getValue()).marshal(_os_);
/*     */       }
/* 624 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 630 */       this.today_campaign_num = _os_.unmarshal_int();
/* 631 */       this.last_campaign_time = _os_.unmarshal_long();
/*     */       
/* 633 */       int size = _os_.uncompact_uint32();
/* 634 */       if (size >= 12)
/*     */       {
/* 636 */         this.campaigns = new HashMap(size * 2);
/*     */       }
/* 638 */       for (; size > 0; size--)
/*     */       {
/* 640 */         int _k_ = 0;
/* 641 */         _k_ = _os_.unmarshal_int();
/* 642 */         xbean.Campaign _v_ = xbean.Pod.newCampaignData();
/* 643 */         _v_.unmarshal(_os_);
/* 644 */         this.campaigns.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 647 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 653 */       int _size_ = 0;
/* 654 */       _size_ += CodedOutputStream.computeInt32Size(1, this.today_campaign_num);
/* 655 */       _size_ += CodedOutputStream.computeInt64Size(2, this.last_campaign_time);
/* 656 */       for (Map.Entry<Integer, xbean.Campaign> _e_ : this.campaigns.entrySet())
/*     */       {
/* 658 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 659 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 661 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 669 */         _output_.writeInt32(1, this.today_campaign_num);
/* 670 */         _output_.writeInt64(2, this.last_campaign_time);
/* 671 */         for (Map.Entry<Integer, xbean.Campaign> _e_ : this.campaigns.entrySet())
/*     */         {
/* 673 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 674 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 679 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 681 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 689 */         boolean done = false;
/* 690 */         while (!done)
/*     */         {
/* 692 */           int tag = _input_.readTag();
/* 693 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 697 */             done = true;
/* 698 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 702 */             this.today_campaign_num = _input_.readInt32();
/* 703 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 707 */             this.last_campaign_time = _input_.readInt64();
/* 708 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 712 */             int _k_ = 0;
/* 713 */             _k_ = _input_.readInt32();
/* 714 */             int readTag = _input_.readTag();
/* 715 */             if (26 != readTag)
/*     */             {
/* 717 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 719 */             xbean.Campaign _v_ = xbean.Pod.newCampaignData();
/* 720 */             _input_.readMessage(_v_);
/* 721 */             this.campaigns.put(Integer.valueOf(_k_), _v_);
/* 722 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 726 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 728 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 737 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 741 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 743 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarCampaignInfo copy()
/*     */     {
/* 749 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarCampaignInfo toData()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MenPaiStarCampaignInfo toBean()
/*     */     {
/* 760 */       return new MenPaiStarCampaignInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarCampaignInfo toDataIf()
/*     */     {
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MenPaiStarCampaignInfo toBeanIf()
/*     */     {
/* 771 */       return new MenPaiStarCampaignInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 777 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 781 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 785 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 789 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 797 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 801 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getToday_campaign_num()
/*     */     {
/* 808 */       return this.today_campaign_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_campaign_time()
/*     */     {
/* 815 */       return this.last_campaign_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Campaign> getCampaigns()
/*     */     {
/* 822 */       return this.campaigns;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Campaign> getCampaignsAsData()
/*     */     {
/* 829 */       return this.campaigns;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_campaign_num(int _v_)
/*     */     {
/* 836 */       this.today_campaign_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_campaign_time(long _v_)
/*     */     {
/* 843 */       this.last_campaign_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 849 */       if (!(_o1_ instanceof Data)) return false;
/* 850 */       Data _o_ = (Data)_o1_;
/* 851 */       if (this.today_campaign_num != _o_.today_campaign_num) return false;
/* 852 */       if (this.last_campaign_time != _o_.last_campaign_time) return false;
/* 853 */       if (!this.campaigns.equals(_o_.campaigns)) return false;
/* 854 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 860 */       int _h_ = 0;
/* 861 */       _h_ += this.today_campaign_num;
/* 862 */       _h_ = (int)(_h_ + this.last_campaign_time);
/* 863 */       _h_ += this.campaigns.hashCode();
/* 864 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 870 */       StringBuilder _sb_ = new StringBuilder();
/* 871 */       _sb_.append("(");
/* 872 */       _sb_.append(this.today_campaign_num);
/* 873 */       _sb_.append(",");
/* 874 */       _sb_.append(this.last_campaign_time);
/* 875 */       _sb_.append(",");
/* 876 */       _sb_.append(this.campaigns);
/* 877 */       _sb_.append(")");
/* 878 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MenPaiStarCampaignInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */