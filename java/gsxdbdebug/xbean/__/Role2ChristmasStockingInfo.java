/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class Role2ChristmasStockingInfo extends XBean implements xbean.Role2ChristmasStockingInfo
/*      */ {
/*      */   private HashMap<Integer, xbean.ChristmasTreePositionInfo> christmastreepositionindex2info;
/*      */   private HashMap<Long, Integer> targetroleid2selfhangnum;
/*      */   private ArrayList<xbean.HangStockingHistoryInfo> hangstockinghistoryinfos;
/*      */   private int getstockinghidingawardnum;
/*      */   private boolean hasgotstockinghidingmail;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.christmastreepositionindex2info.clear();
/*   27 */     this.targetroleid2selfhangnum.clear();
/*   28 */     this.hangstockinghistoryinfos.clear();
/*   29 */     this.getstockinghidingawardnum = 0;
/*   30 */     this.hasgotstockinghidingmail = false;
/*      */   }
/*      */   
/*      */   Role2ChristmasStockingInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.christmastreepositionindex2info = new HashMap();
/*   37 */     this.targetroleid2selfhangnum = new HashMap();
/*   38 */     this.hangstockinghistoryinfos = new ArrayList();
/*      */   }
/*      */   
/*      */   public Role2ChristmasStockingInfo()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Role2ChristmasStockingInfo(Role2ChristmasStockingInfo _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Role2ChristmasStockingInfo(xbean.Role2ChristmasStockingInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof Role2ChristmasStockingInfo)) { assign((Role2ChristmasStockingInfo)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Role2ChristmasStockingInfo _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.christmastreepositionindex2info = new HashMap();
/*   64 */     for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : _o_.christmastreepositionindex2info.entrySet())
/*   65 */       this.christmastreepositionindex2info.put(_e_.getKey(), new ChristmasTreePositionInfo((xbean.ChristmasTreePositionInfo)_e_.getValue(), this, "christmastreepositionindex2info"));
/*   66 */     this.targetroleid2selfhangnum = new HashMap();
/*   67 */     for (Map.Entry<Long, Integer> _e_ : _o_.targetroleid2selfhangnum.entrySet())
/*   68 */       this.targetroleid2selfhangnum.put(_e_.getKey(), _e_.getValue());
/*   69 */     this.hangstockinghistoryinfos = new ArrayList();
/*   70 */     for (xbean.HangStockingHistoryInfo _v_ : _o_.hangstockinghistoryinfos)
/*   71 */       this.hangstockinghistoryinfos.add(new HangStockingHistoryInfo(_v_, this, "hangstockinghistoryinfos"));
/*   72 */     this.getstockinghidingawardnum = _o_.getstockinghidingawardnum;
/*   73 */     this.hasgotstockinghidingmail = _o_.hasgotstockinghidingmail;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   78 */     this.christmastreepositionindex2info = new HashMap();
/*   79 */     for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : _o_.christmastreepositionindex2info.entrySet())
/*   80 */       this.christmastreepositionindex2info.put(_e_.getKey(), new ChristmasTreePositionInfo((xbean.ChristmasTreePositionInfo)_e_.getValue(), this, "christmastreepositionindex2info"));
/*   81 */     this.targetroleid2selfhangnum = new HashMap();
/*   82 */     for (Map.Entry<Long, Integer> _e_ : _o_.targetroleid2selfhangnum.entrySet())
/*   83 */       this.targetroleid2selfhangnum.put(_e_.getKey(), _e_.getValue());
/*   84 */     this.hangstockinghistoryinfos = new ArrayList();
/*   85 */     for (xbean.HangStockingHistoryInfo _v_ : _o_.hangstockinghistoryinfos)
/*   86 */       this.hangstockinghistoryinfos.add(new HangStockingHistoryInfo(_v_, this, "hangstockinghistoryinfos"));
/*   87 */     this.getstockinghidingawardnum = _o_.getstockinghidingawardnum;
/*   88 */     this.hasgotstockinghidingmail = _o_.hasgotstockinghidingmail;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   94 */     _xdb_verify_unsafe_();
/*   95 */     _os_.compact_uint32(this.christmastreepositionindex2info.size());
/*   96 */     for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : this.christmastreepositionindex2info.entrySet())
/*      */     {
/*   98 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   99 */       ((xbean.ChristmasTreePositionInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  101 */     _os_.compact_uint32(this.targetroleid2selfhangnum.size());
/*  102 */     for (Map.Entry<Long, Integer> _e_ : this.targetroleid2selfhangnum.entrySet())
/*      */     {
/*  104 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  105 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  107 */     _os_.compact_uint32(this.hangstockinghistoryinfos.size());
/*  108 */     for (xbean.HangStockingHistoryInfo _v_ : this.hangstockinghistoryinfos)
/*      */     {
/*  110 */       _v_.marshal(_os_);
/*      */     }
/*  112 */     _os_.marshal(this.getstockinghidingawardnum);
/*  113 */     _os_.marshal(this.hasgotstockinghidingmail);
/*  114 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  120 */     _xdb_verify_unsafe_();
/*      */     
/*  122 */     int size = _os_.uncompact_uint32();
/*  123 */     if (size >= 12)
/*      */     {
/*  125 */       this.christmastreepositionindex2info = new HashMap(size * 2);
/*      */     }
/*  127 */     for (; size > 0; size--)
/*      */     {
/*  129 */       int _k_ = 0;
/*  130 */       _k_ = _os_.unmarshal_int();
/*  131 */       xbean.ChristmasTreePositionInfo _v_ = new ChristmasTreePositionInfo(0, this, "christmastreepositionindex2info");
/*  132 */       _v_.unmarshal(_os_);
/*  133 */       this.christmastreepositionindex2info.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  137 */     int size = _os_.uncompact_uint32();
/*  138 */     if (size >= 12)
/*      */     {
/*  140 */       this.targetroleid2selfhangnum = new HashMap(size * 2);
/*      */     }
/*  142 */     for (; size > 0; size--)
/*      */     {
/*  144 */       long _k_ = 0L;
/*  145 */       _k_ = _os_.unmarshal_long();
/*  146 */       int _v_ = 0;
/*  147 */       _v_ = _os_.unmarshal_int();
/*  148 */       this.targetroleid2selfhangnum.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  151 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  153 */       xbean.HangStockingHistoryInfo _v_ = new HangStockingHistoryInfo(0, this, "hangstockinghistoryinfos");
/*  154 */       _v_.unmarshal(_os_);
/*  155 */       this.hangstockinghistoryinfos.add(_v_);
/*      */     }
/*  157 */     this.getstockinghidingawardnum = _os_.unmarshal_int();
/*  158 */     this.hasgotstockinghidingmail = _os_.unmarshal_boolean();
/*  159 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  165 */     _xdb_verify_unsafe_();
/*  166 */     int _size_ = 0;
/*  167 */     for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : this.christmastreepositionindex2info.entrySet())
/*      */     {
/*  169 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  170 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */     }
/*  172 */     for (Map.Entry<Long, Integer> _e_ : this.targetroleid2selfhangnum.entrySet())
/*      */     {
/*  174 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  175 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  177 */     for (xbean.HangStockingHistoryInfo _v_ : this.hangstockinghistoryinfos)
/*      */     {
/*  179 */       _size_ += CodedOutputStream.computeMessageSize(3, _v_);
/*      */     }
/*  181 */     _size_ += CodedOutputStream.computeInt32Size(4, this.getstockinghidingawardnum);
/*  182 */     _size_ += CodedOutputStream.computeBoolSize(5, this.hasgotstockinghidingmail);
/*  183 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  189 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  192 */       for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : this.christmastreepositionindex2info.entrySet())
/*      */       {
/*  194 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  195 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  197 */       for (Map.Entry<Long, Integer> _e_ : this.targetroleid2selfhangnum.entrySet())
/*      */       {
/*  199 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  200 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  202 */       for (xbean.HangStockingHistoryInfo _v_ : this.hangstockinghistoryinfos)
/*      */       {
/*  204 */         _output_.writeMessage(3, _v_);
/*      */       }
/*  206 */       _output_.writeInt32(4, this.getstockinghidingawardnum);
/*  207 */       _output_.writeBool(5, this.hasgotstockinghidingmail);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  211 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  213 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  219 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  222 */       boolean done = false;
/*  223 */       while (!done)
/*      */       {
/*  225 */         int tag = _input_.readTag();
/*  226 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  230 */           done = true;
/*  231 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  235 */           int _k_ = 0;
/*  236 */           _k_ = _input_.readInt32();
/*  237 */           int readTag = _input_.readTag();
/*  238 */           if (10 != readTag)
/*      */           {
/*  240 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  242 */           xbean.ChristmasTreePositionInfo _v_ = new ChristmasTreePositionInfo(0, this, "christmastreepositionindex2info");
/*  243 */           _input_.readMessage(_v_);
/*  244 */           this.christmastreepositionindex2info.put(Integer.valueOf(_k_), _v_);
/*  245 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  249 */           long _k_ = 0L;
/*  250 */           _k_ = _input_.readInt64();
/*  251 */           int readTag = _input_.readTag();
/*  252 */           if (16 != readTag)
/*      */           {
/*  254 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  256 */           int _v_ = 0;
/*  257 */           _v_ = _input_.readInt32();
/*  258 */           this.targetroleid2selfhangnum.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  259 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  263 */           xbean.HangStockingHistoryInfo _v_ = new HangStockingHistoryInfo(0, this, "hangstockinghistoryinfos");
/*  264 */           _input_.readMessage(_v_);
/*  265 */           this.hangstockinghistoryinfos.add(_v_);
/*  266 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  270 */           this.getstockinghidingawardnum = _input_.readInt32();
/*  271 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  275 */           this.hasgotstockinghidingmail = _input_.readBool();
/*  276 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  280 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  282 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  291 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  295 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  297 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2ChristmasStockingInfo copy()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return new Role2ChristmasStockingInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2ChristmasStockingInfo toData()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2ChristmasStockingInfo toBean()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return new Role2ChristmasStockingInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2ChristmasStockingInfo toDataIf()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2ChristmasStockingInfo toBeanIf()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ChristmasTreePositionInfo> getChristmastreepositionindex2info()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return xdb.Logs.logMap(new LogKey(this, "christmastreepositionindex2info"), this.christmastreepositionindex2info);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ChristmasTreePositionInfo> getChristmastreepositionindex2infoAsData()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*      */     
/*  354 */     Role2ChristmasStockingInfo _o_ = this;
/*  355 */     Map<Integer, xbean.ChristmasTreePositionInfo> christmastreepositionindex2info = new HashMap();
/*  356 */     for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : _o_.christmastreepositionindex2info.entrySet())
/*  357 */       christmastreepositionindex2info.put(_e_.getKey(), new ChristmasTreePositionInfo.Data((xbean.ChristmasTreePositionInfo)_e_.getValue()));
/*  358 */     return christmastreepositionindex2info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getTargetroleid2selfhangnum()
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     return xdb.Logs.logMap(new LogKey(this, "targetroleid2selfhangnum"), this.targetroleid2selfhangnum);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getTargetroleid2selfhangnumAsData()
/*      */   {
/*  373 */     _xdb_verify_unsafe_();
/*      */     
/*  375 */     Role2ChristmasStockingInfo _o_ = this;
/*  376 */     Map<Long, Integer> targetroleid2selfhangnum = new HashMap();
/*  377 */     for (Map.Entry<Long, Integer> _e_ : _o_.targetroleid2selfhangnum.entrySet())
/*  378 */       targetroleid2selfhangnum.put(_e_.getKey(), _e_.getValue());
/*  379 */     return targetroleid2selfhangnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.HangStockingHistoryInfo> getHangstockinghistoryinfos()
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     return xdb.Logs.logList(new LogKey(this, "hangstockinghistoryinfos"), this.hangstockinghistoryinfos);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.HangStockingHistoryInfo> getHangstockinghistoryinfosAsData()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*      */     
/*  395 */     Role2ChristmasStockingInfo _o_ = this;
/*  396 */     List<xbean.HangStockingHistoryInfo> hangstockinghistoryinfos = new ArrayList();
/*  397 */     for (xbean.HangStockingHistoryInfo _v_ : _o_.hangstockinghistoryinfos)
/*  398 */       hangstockinghistoryinfos.add(new HangStockingHistoryInfo.Data(_v_));
/*  399 */     return hangstockinghistoryinfos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGetstockinghidingawardnum()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return this.getstockinghidingawardnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getHasgotstockinghidingmail()
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     return this.hasgotstockinghidingmail;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGetstockinghidingawardnum(int _v_)
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     xdb.Logs.logIf(new LogKey(this, "getstockinghidingawardnum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  427 */         new xdb.logs.LogInt(this, Role2ChristmasStockingInfo.this.getstockinghidingawardnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  431 */             Role2ChristmasStockingInfo.this.getstockinghidingawardnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  435 */     });
/*  436 */     this.getstockinghidingawardnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHasgotstockinghidingmail(boolean _v_)
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     xdb.Logs.logIf(new LogKey(this, "hasgotstockinghidingmail")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  448 */         new xdb.logs.LogObject(this, Boolean.valueOf(Role2ChristmasStockingInfo.this.hasgotstockinghidingmail))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  452 */             Role2ChristmasStockingInfo.this.hasgotstockinghidingmail = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  456 */     });
/*  457 */     this.hasgotstockinghidingmail = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*  464 */     Role2ChristmasStockingInfo _o_ = null;
/*  465 */     if ((_o1_ instanceof Role2ChristmasStockingInfo)) { _o_ = (Role2ChristmasStockingInfo)_o1_;
/*  466 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  467 */       return false;
/*  468 */     if (!this.christmastreepositionindex2info.equals(_o_.christmastreepositionindex2info)) return false;
/*  469 */     if (!this.targetroleid2selfhangnum.equals(_o_.targetroleid2selfhangnum)) return false;
/*  470 */     if (!this.hangstockinghistoryinfos.equals(_o_.hangstockinghistoryinfos)) return false;
/*  471 */     if (this.getstockinghidingawardnum != _o_.getstockinghidingawardnum) return false;
/*  472 */     if (this.hasgotstockinghidingmail != _o_.hasgotstockinghidingmail) return false;
/*  473 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  479 */     _xdb_verify_unsafe_();
/*  480 */     int _h_ = 0;
/*  481 */     _h_ += this.christmastreepositionindex2info.hashCode();
/*  482 */     _h_ += this.targetroleid2selfhangnum.hashCode();
/*  483 */     _h_ += this.hangstockinghistoryinfos.hashCode();
/*  484 */     _h_ += this.getstockinghidingawardnum;
/*  485 */     _h_ += (this.hasgotstockinghidingmail ? 1231 : 1237);
/*  486 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  492 */     _xdb_verify_unsafe_();
/*  493 */     StringBuilder _sb_ = new StringBuilder();
/*  494 */     _sb_.append("(");
/*  495 */     _sb_.append(this.christmastreepositionindex2info);
/*  496 */     _sb_.append(",");
/*  497 */     _sb_.append(this.targetroleid2selfhangnum);
/*  498 */     _sb_.append(",");
/*  499 */     _sb_.append(this.hangstockinghistoryinfos);
/*  500 */     _sb_.append(",");
/*  501 */     _sb_.append(this.getstockinghidingawardnum);
/*  502 */     _sb_.append(",");
/*  503 */     _sb_.append(this.hasgotstockinghidingmail);
/*  504 */     _sb_.append(")");
/*  505 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  511 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  512 */     lb.add(new xdb.logs.ListenableMap().setVarName("christmastreepositionindex2info"));
/*  513 */     lb.add(new xdb.logs.ListenableMap().setVarName("targetroleid2selfhangnum"));
/*  514 */     lb.add(new xdb.logs.ListenableChanged().setVarName("hangstockinghistoryinfos"));
/*  515 */     lb.add(new xdb.logs.ListenableChanged().setVarName("getstockinghidingawardnum"));
/*  516 */     lb.add(new xdb.logs.ListenableChanged().setVarName("hasgotstockinghidingmail"));
/*  517 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Role2ChristmasStockingInfo {
/*      */     private Const() {}
/*      */     
/*      */     Role2ChristmasStockingInfo nThis() {
/*  524 */       return Role2ChristmasStockingInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  530 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChristmasStockingInfo copy()
/*      */     {
/*  536 */       return Role2ChristmasStockingInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChristmasStockingInfo toData()
/*      */     {
/*  542 */       return Role2ChristmasStockingInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Role2ChristmasStockingInfo toBean()
/*      */     {
/*  547 */       return Role2ChristmasStockingInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChristmasStockingInfo toDataIf()
/*      */     {
/*  553 */       return Role2ChristmasStockingInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Role2ChristmasStockingInfo toBeanIf()
/*      */     {
/*  558 */       return Role2ChristmasStockingInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChristmasTreePositionInfo> getChristmastreepositionindex2info()
/*      */     {
/*  565 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*  566 */       return xdb.Consts.constMap(Role2ChristmasStockingInfo.this.christmastreepositionindex2info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChristmasTreePositionInfo> getChristmastreepositionindex2infoAsData()
/*      */     {
/*  573 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*      */       
/*  575 */       Role2ChristmasStockingInfo _o_ = Role2ChristmasStockingInfo.this;
/*  576 */       Map<Integer, xbean.ChristmasTreePositionInfo> christmastreepositionindex2info = new HashMap();
/*  577 */       for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : _o_.christmastreepositionindex2info.entrySet())
/*  578 */         christmastreepositionindex2info.put(_e_.getKey(), new ChristmasTreePositionInfo.Data((xbean.ChristmasTreePositionInfo)_e_.getValue()));
/*  579 */       return christmastreepositionindex2info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getTargetroleid2selfhangnum()
/*      */     {
/*  586 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*  587 */       return xdb.Consts.constMap(Role2ChristmasStockingInfo.this.targetroleid2selfhangnum);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getTargetroleid2selfhangnumAsData()
/*      */     {
/*  594 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*      */       
/*  596 */       Role2ChristmasStockingInfo _o_ = Role2ChristmasStockingInfo.this;
/*  597 */       Map<Long, Integer> targetroleid2selfhangnum = new HashMap();
/*  598 */       for (Map.Entry<Long, Integer> _e_ : _o_.targetroleid2selfhangnum.entrySet())
/*  599 */         targetroleid2selfhangnum.put(_e_.getKey(), _e_.getValue());
/*  600 */       return targetroleid2selfhangnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.HangStockingHistoryInfo> getHangstockinghistoryinfos()
/*      */     {
/*  607 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*  608 */       return xdb.Consts.constList(Role2ChristmasStockingInfo.this.hangstockinghistoryinfos);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.HangStockingHistoryInfo> getHangstockinghistoryinfosAsData()
/*      */     {
/*  614 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*      */       
/*  616 */       Role2ChristmasStockingInfo _o_ = Role2ChristmasStockingInfo.this;
/*  617 */       List<xbean.HangStockingHistoryInfo> hangstockinghistoryinfos = new ArrayList();
/*  618 */       for (xbean.HangStockingHistoryInfo _v_ : _o_.hangstockinghistoryinfos)
/*  619 */         hangstockinghistoryinfos.add(new HangStockingHistoryInfo.Data(_v_));
/*  620 */       return hangstockinghistoryinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGetstockinghidingawardnum()
/*      */     {
/*  627 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*  628 */       return Role2ChristmasStockingInfo.this.getstockinghidingawardnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHasgotstockinghidingmail()
/*      */     {
/*  635 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*  636 */       return Role2ChristmasStockingInfo.this.hasgotstockinghidingmail;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGetstockinghidingawardnum(int _v_)
/*      */     {
/*  643 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*  644 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHasgotstockinghidingmail(boolean _v_)
/*      */     {
/*  651 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*  652 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  658 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*  659 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  665 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*  666 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  672 */       return Role2ChristmasStockingInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  678 */       return Role2ChristmasStockingInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  684 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*  685 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  691 */       return Role2ChristmasStockingInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  697 */       return Role2ChristmasStockingInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  703 */       Role2ChristmasStockingInfo.this._xdb_verify_unsafe_();
/*  704 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  710 */       return Role2ChristmasStockingInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  716 */       return Role2ChristmasStockingInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  722 */       return Role2ChristmasStockingInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  728 */       return Role2ChristmasStockingInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  734 */       return Role2ChristmasStockingInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  740 */       return Role2ChristmasStockingInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  746 */       return Role2ChristmasStockingInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Role2ChristmasStockingInfo
/*      */   {
/*      */     private HashMap<Integer, xbean.ChristmasTreePositionInfo> christmastreepositionindex2info;
/*      */     
/*      */     private HashMap<Long, Integer> targetroleid2selfhangnum;
/*      */     
/*      */     private ArrayList<xbean.HangStockingHistoryInfo> hangstockinghistoryinfos;
/*      */     
/*      */     private int getstockinghidingawardnum;
/*      */     
/*      */     private boolean hasgotstockinghidingmail;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  766 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  771 */       this.christmastreepositionindex2info = new HashMap();
/*  772 */       this.targetroleid2selfhangnum = new HashMap();
/*  773 */       this.hangstockinghistoryinfos = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.Role2ChristmasStockingInfo _o1_)
/*      */     {
/*  778 */       if ((_o1_ instanceof Role2ChristmasStockingInfo)) { assign((Role2ChristmasStockingInfo)_o1_);
/*  779 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  780 */       } else if ((_o1_ instanceof Role2ChristmasStockingInfo.Const)) assign(((Role2ChristmasStockingInfo.Const)_o1_).nThis()); else {
/*  781 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Role2ChristmasStockingInfo _o_) {
/*  786 */       this.christmastreepositionindex2info = new HashMap();
/*  787 */       for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : _o_.christmastreepositionindex2info.entrySet())
/*  788 */         this.christmastreepositionindex2info.put(_e_.getKey(), new ChristmasTreePositionInfo.Data((xbean.ChristmasTreePositionInfo)_e_.getValue()));
/*  789 */       this.targetroleid2selfhangnum = new HashMap();
/*  790 */       for (Map.Entry<Long, Integer> _e_ : _o_.targetroleid2selfhangnum.entrySet())
/*  791 */         this.targetroleid2selfhangnum.put(_e_.getKey(), _e_.getValue());
/*  792 */       this.hangstockinghistoryinfos = new ArrayList();
/*  793 */       for (xbean.HangStockingHistoryInfo _v_ : _o_.hangstockinghistoryinfos)
/*  794 */         this.hangstockinghistoryinfos.add(new HangStockingHistoryInfo.Data(_v_));
/*  795 */       this.getstockinghidingawardnum = _o_.getstockinghidingawardnum;
/*  796 */       this.hasgotstockinghidingmail = _o_.hasgotstockinghidingmail;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  801 */       this.christmastreepositionindex2info = new HashMap();
/*  802 */       for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : _o_.christmastreepositionindex2info.entrySet())
/*  803 */         this.christmastreepositionindex2info.put(_e_.getKey(), new ChristmasTreePositionInfo.Data((xbean.ChristmasTreePositionInfo)_e_.getValue()));
/*  804 */       this.targetroleid2selfhangnum = new HashMap();
/*  805 */       for (Map.Entry<Long, Integer> _e_ : _o_.targetroleid2selfhangnum.entrySet())
/*  806 */         this.targetroleid2selfhangnum.put(_e_.getKey(), _e_.getValue());
/*  807 */       this.hangstockinghistoryinfos = new ArrayList();
/*  808 */       for (xbean.HangStockingHistoryInfo _v_ : _o_.hangstockinghistoryinfos)
/*  809 */         this.hangstockinghistoryinfos.add(new HangStockingHistoryInfo.Data(_v_));
/*  810 */       this.getstockinghidingawardnum = _o_.getstockinghidingawardnum;
/*  811 */       this.hasgotstockinghidingmail = _o_.hasgotstockinghidingmail;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  817 */       _os_.compact_uint32(this.christmastreepositionindex2info.size());
/*  818 */       for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : this.christmastreepositionindex2info.entrySet())
/*      */       {
/*  820 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  821 */         ((xbean.ChristmasTreePositionInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  823 */       _os_.compact_uint32(this.targetroleid2selfhangnum.size());
/*  824 */       for (Map.Entry<Long, Integer> _e_ : this.targetroleid2selfhangnum.entrySet())
/*      */       {
/*  826 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  827 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  829 */       _os_.compact_uint32(this.hangstockinghistoryinfos.size());
/*  830 */       for (xbean.HangStockingHistoryInfo _v_ : this.hangstockinghistoryinfos)
/*      */       {
/*  832 */         _v_.marshal(_os_);
/*      */       }
/*  834 */       _os_.marshal(this.getstockinghidingawardnum);
/*  835 */       _os_.marshal(this.hasgotstockinghidingmail);
/*  836 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  843 */       int size = _os_.uncompact_uint32();
/*  844 */       if (size >= 12)
/*      */       {
/*  846 */         this.christmastreepositionindex2info = new HashMap(size * 2);
/*      */       }
/*  848 */       for (; size > 0; size--)
/*      */       {
/*  850 */         int _k_ = 0;
/*  851 */         _k_ = _os_.unmarshal_int();
/*  852 */         xbean.ChristmasTreePositionInfo _v_ = xbean.Pod.newChristmasTreePositionInfoData();
/*  853 */         _v_.unmarshal(_os_);
/*  854 */         this.christmastreepositionindex2info.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  858 */       int size = _os_.uncompact_uint32();
/*  859 */       if (size >= 12)
/*      */       {
/*  861 */         this.targetroleid2selfhangnum = new HashMap(size * 2);
/*      */       }
/*  863 */       for (; size > 0; size--)
/*      */       {
/*  865 */         long _k_ = 0L;
/*  866 */         _k_ = _os_.unmarshal_long();
/*  867 */         int _v_ = 0;
/*  868 */         _v_ = _os_.unmarshal_int();
/*  869 */         this.targetroleid2selfhangnum.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  872 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  874 */         xbean.HangStockingHistoryInfo _v_ = xbean.Pod.newHangStockingHistoryInfoData();
/*  875 */         _v_.unmarshal(_os_);
/*  876 */         this.hangstockinghistoryinfos.add(_v_);
/*      */       }
/*  878 */       this.getstockinghidingawardnum = _os_.unmarshal_int();
/*  879 */       this.hasgotstockinghidingmail = _os_.unmarshal_boolean();
/*  880 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  886 */       int _size_ = 0;
/*  887 */       for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : this.christmastreepositionindex2info.entrySet())
/*      */       {
/*  889 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  890 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  892 */       for (Map.Entry<Long, Integer> _e_ : this.targetroleid2selfhangnum.entrySet())
/*      */       {
/*  894 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  895 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  897 */       for (xbean.HangStockingHistoryInfo _v_ : this.hangstockinghistoryinfos)
/*      */       {
/*  899 */         _size_ += CodedOutputStream.computeMessageSize(3, _v_);
/*      */       }
/*  901 */       _size_ += CodedOutputStream.computeInt32Size(4, this.getstockinghidingawardnum);
/*  902 */       _size_ += CodedOutputStream.computeBoolSize(5, this.hasgotstockinghidingmail);
/*  903 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  911 */         for (Map.Entry<Integer, xbean.ChristmasTreePositionInfo> _e_ : this.christmastreepositionindex2info.entrySet())
/*      */         {
/*  913 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  914 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */         }
/*  916 */         for (Map.Entry<Long, Integer> _e_ : this.targetroleid2selfhangnum.entrySet())
/*      */         {
/*  918 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  919 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  921 */         for (xbean.HangStockingHistoryInfo _v_ : this.hangstockinghistoryinfos)
/*      */         {
/*  923 */           _output_.writeMessage(3, _v_);
/*      */         }
/*  925 */         _output_.writeInt32(4, this.getstockinghidingawardnum);
/*  926 */         _output_.writeBool(5, this.hasgotstockinghidingmail);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  930 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  932 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  940 */         boolean done = false;
/*  941 */         while (!done)
/*      */         {
/*  943 */           int tag = _input_.readTag();
/*  944 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  948 */             done = true;
/*  949 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  953 */             int _k_ = 0;
/*  954 */             _k_ = _input_.readInt32();
/*  955 */             int readTag = _input_.readTag();
/*  956 */             if (10 != readTag)
/*      */             {
/*  958 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  960 */             xbean.ChristmasTreePositionInfo _v_ = xbean.Pod.newChristmasTreePositionInfoData();
/*  961 */             _input_.readMessage(_v_);
/*  962 */             this.christmastreepositionindex2info.put(Integer.valueOf(_k_), _v_);
/*  963 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  967 */             long _k_ = 0L;
/*  968 */             _k_ = _input_.readInt64();
/*  969 */             int readTag = _input_.readTag();
/*  970 */             if (16 != readTag)
/*      */             {
/*  972 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  974 */             int _v_ = 0;
/*  975 */             _v_ = _input_.readInt32();
/*  976 */             this.targetroleid2selfhangnum.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  977 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/*  981 */             xbean.HangStockingHistoryInfo _v_ = xbean.Pod.newHangStockingHistoryInfoData();
/*  982 */             _input_.readMessage(_v_);
/*  983 */             this.hangstockinghistoryinfos.add(_v_);
/*  984 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  988 */             this.getstockinghidingawardnum = _input_.readInt32();
/*  989 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  993 */             this.hasgotstockinghidingmail = _input_.readBool();
/*  994 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  998 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1000 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1009 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1013 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1015 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChristmasStockingInfo copy()
/*      */     {
/* 1021 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChristmasStockingInfo toData()
/*      */     {
/* 1027 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Role2ChristmasStockingInfo toBean()
/*      */     {
/* 1032 */       return new Role2ChristmasStockingInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChristmasStockingInfo toDataIf()
/*      */     {
/* 1038 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Role2ChristmasStockingInfo toBeanIf()
/*      */     {
/* 1043 */       return new Role2ChristmasStockingInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1049 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1053 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1057 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1061 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1065 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1069 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1073 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChristmasTreePositionInfo> getChristmastreepositionindex2info()
/*      */     {
/* 1080 */       return this.christmastreepositionindex2info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChristmasTreePositionInfo> getChristmastreepositionindex2infoAsData()
/*      */     {
/* 1087 */       return this.christmastreepositionindex2info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getTargetroleid2selfhangnum()
/*      */     {
/* 1094 */       return this.targetroleid2selfhangnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getTargetroleid2selfhangnumAsData()
/*      */     {
/* 1101 */       return this.targetroleid2selfhangnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.HangStockingHistoryInfo> getHangstockinghistoryinfos()
/*      */     {
/* 1108 */       return this.hangstockinghistoryinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.HangStockingHistoryInfo> getHangstockinghistoryinfosAsData()
/*      */     {
/* 1115 */       return this.hangstockinghistoryinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGetstockinghidingawardnum()
/*      */     {
/* 1122 */       return this.getstockinghidingawardnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHasgotstockinghidingmail()
/*      */     {
/* 1129 */       return this.hasgotstockinghidingmail;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGetstockinghidingawardnum(int _v_)
/*      */     {
/* 1136 */       this.getstockinghidingawardnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHasgotstockinghidingmail(boolean _v_)
/*      */     {
/* 1143 */       this.hasgotstockinghidingmail = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1149 */       if (!(_o1_ instanceof Data)) return false;
/* 1150 */       Data _o_ = (Data)_o1_;
/* 1151 */       if (!this.christmastreepositionindex2info.equals(_o_.christmastreepositionindex2info)) return false;
/* 1152 */       if (!this.targetroleid2selfhangnum.equals(_o_.targetroleid2selfhangnum)) return false;
/* 1153 */       if (!this.hangstockinghistoryinfos.equals(_o_.hangstockinghistoryinfos)) return false;
/* 1154 */       if (this.getstockinghidingawardnum != _o_.getstockinghidingawardnum) return false;
/* 1155 */       if (this.hasgotstockinghidingmail != _o_.hasgotstockinghidingmail) return false;
/* 1156 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1162 */       int _h_ = 0;
/* 1163 */       _h_ += this.christmastreepositionindex2info.hashCode();
/* 1164 */       _h_ += this.targetroleid2selfhangnum.hashCode();
/* 1165 */       _h_ += this.hangstockinghistoryinfos.hashCode();
/* 1166 */       _h_ += this.getstockinghidingawardnum;
/* 1167 */       _h_ += (this.hasgotstockinghidingmail ? 1231 : 1237);
/* 1168 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1174 */       StringBuilder _sb_ = new StringBuilder();
/* 1175 */       _sb_.append("(");
/* 1176 */       _sb_.append(this.christmastreepositionindex2info);
/* 1177 */       _sb_.append(",");
/* 1178 */       _sb_.append(this.targetroleid2selfhangnum);
/* 1179 */       _sb_.append(",");
/* 1180 */       _sb_.append(this.hangstockinghistoryinfos);
/* 1181 */       _sb_.append(",");
/* 1182 */       _sb_.append(this.getstockinghidingawardnum);
/* 1183 */       _sb_.append(",");
/* 1184 */       _sb_.append(this.hasgotstockinghidingmail);
/* 1185 */       _sb_.append(")");
/* 1186 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2ChristmasStockingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */