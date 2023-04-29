/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ 
/*      */ public final class CampInfo extends XBean implements xbean.CampInfo
/*      */ {
/*      */   private HashMap<Long, Integer> roleid2state;
/*      */   private int source;
/*      */   private HashMap<Long, xbean.roleBattleData> rolebattledatas;
/*      */   private boolean surrender;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.roleid2state.clear();
/*   25 */     this.source = 0;
/*   26 */     this.rolebattledatas.clear();
/*   27 */     this.surrender = false;
/*      */   }
/*      */   
/*      */   CampInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.roleid2state = new HashMap();
/*   34 */     this.rolebattledatas = new HashMap();
/*      */   }
/*      */   
/*      */   public CampInfo()
/*      */   {
/*   39 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CampInfo(CampInfo _o_)
/*      */   {
/*   44 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CampInfo(xbean.CampInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   49 */     super(_xp_, _vn_);
/*   50 */     if ((_o1_ instanceof CampInfo)) { assign((CampInfo)_o1_);
/*   51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   53 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CampInfo _o_) {
/*   58 */     _o_._xdb_verify_unsafe_();
/*   59 */     this.roleid2state = new HashMap();
/*   60 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2state.entrySet())
/*   61 */       this.roleid2state.put(_e_.getKey(), _e_.getValue());
/*   62 */     this.source = _o_.source;
/*   63 */     this.rolebattledatas = new HashMap();
/*   64 */     for (Map.Entry<Long, xbean.roleBattleData> _e_ : _o_.rolebattledatas.entrySet())
/*   65 */       this.rolebattledatas.put(_e_.getKey(), new roleBattleData((xbean.roleBattleData)_e_.getValue(), this, "rolebattledatas"));
/*   66 */     this.surrender = _o_.surrender;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   71 */     this.roleid2state = new HashMap();
/*   72 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2state.entrySet())
/*   73 */       this.roleid2state.put(_e_.getKey(), _e_.getValue());
/*   74 */     this.source = _o_.source;
/*   75 */     this.rolebattledatas = new HashMap();
/*   76 */     for (Map.Entry<Long, xbean.roleBattleData> _e_ : _o_.rolebattledatas.entrySet())
/*   77 */       this.rolebattledatas.put(_e_.getKey(), new roleBattleData((xbean.roleBattleData)_e_.getValue(), this, "rolebattledatas"));
/*   78 */     this.surrender = _o_.surrender;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.compact_uint32(this.roleid2state.size());
/*   86 */     for (Map.Entry<Long, Integer> _e_ : this.roleid2state.entrySet())
/*      */     {
/*   88 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   89 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   91 */     _os_.marshal(this.source);
/*   92 */     _os_.compact_uint32(this.rolebattledatas.size());
/*   93 */     for (Map.Entry<Long, xbean.roleBattleData> _e_ : this.rolebattledatas.entrySet())
/*      */     {
/*   95 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   96 */       ((xbean.roleBattleData)_e_.getValue()).marshal(_os_);
/*      */     }
/*   98 */     _os_.marshal(this.surrender);
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*      */     
/*  107 */     int size = _os_.uncompact_uint32();
/*  108 */     if (size >= 12)
/*      */     {
/*  110 */       this.roleid2state = new HashMap(size * 2);
/*      */     }
/*  112 */     for (; size > 0; size--)
/*      */     {
/*  114 */       long _k_ = 0L;
/*  115 */       _k_ = _os_.unmarshal_long();
/*  116 */       int _v_ = 0;
/*  117 */       _v_ = _os_.unmarshal_int();
/*  118 */       this.roleid2state.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  121 */     this.source = _os_.unmarshal_int();
/*      */     
/*  123 */     int size = _os_.uncompact_uint32();
/*  124 */     if (size >= 12)
/*      */     {
/*  126 */       this.rolebattledatas = new HashMap(size * 2);
/*      */     }
/*  128 */     for (; size > 0; size--)
/*      */     {
/*  130 */       long _k_ = 0L;
/*  131 */       _k_ = _os_.unmarshal_long();
/*  132 */       xbean.roleBattleData _v_ = new roleBattleData(0, this, "rolebattledatas");
/*  133 */       _v_.unmarshal(_os_);
/*  134 */       this.rolebattledatas.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  137 */     this.surrender = _os_.unmarshal_boolean();
/*  138 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*  145 */     int _size_ = 0;
/*  146 */     for (Map.Entry<Long, Integer> _e_ : this.roleid2state.entrySet())
/*      */     {
/*  148 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  149 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  151 */     _size_ += CodedOutputStream.computeInt32Size(2, this.source);
/*  152 */     for (Map.Entry<Long, xbean.roleBattleData> _e_ : this.rolebattledatas.entrySet())
/*      */     {
/*  154 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  155 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */     }
/*  157 */     _size_ += CodedOutputStream.computeBoolSize(4, this.surrender);
/*  158 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  167 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2state.entrySet())
/*      */       {
/*  169 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  170 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  172 */       _output_.writeInt32(2, this.source);
/*  173 */       for (Map.Entry<Long, xbean.roleBattleData> _e_ : this.rolebattledatas.entrySet())
/*      */       {
/*  175 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  176 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  178 */       _output_.writeBool(4, this.surrender);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  182 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  184 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  190 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  193 */       boolean done = false;
/*  194 */       while (!done)
/*      */       {
/*  196 */         int tag = _input_.readTag();
/*  197 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  201 */           done = true;
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  206 */           long _k_ = 0L;
/*  207 */           _k_ = _input_.readInt64();
/*  208 */           int readTag = _input_.readTag();
/*  209 */           if (8 != readTag)
/*      */           {
/*  211 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  213 */           int _v_ = 0;
/*  214 */           _v_ = _input_.readInt32();
/*  215 */           this.roleid2state.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  220 */           this.source = _input_.readInt32();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  225 */           long _k_ = 0L;
/*  226 */           _k_ = _input_.readInt64();
/*  227 */           int readTag = _input_.readTag();
/*  228 */           if (26 != readTag)
/*      */           {
/*  230 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  232 */           xbean.roleBattleData _v_ = new roleBattleData(0, this, "rolebattledatas");
/*  233 */           _input_.readMessage(_v_);
/*  234 */           this.rolebattledatas.put(Long.valueOf(_k_), _v_);
/*  235 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  239 */           this.surrender = _input_.readBool();
/*  240 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  244 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  246 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  255 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  259 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  261 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CampInfo copy()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new CampInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CampInfo toData()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CampInfo toBean()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return new CampInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CampInfo toDataIf()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CampInfo toBeanIf()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRoleid2state()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return xdb.Logs.logMap(new LogKey(this, "roleid2state"), this.roleid2state);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRoleid2stateAsData()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*      */     
/*  318 */     CampInfo _o_ = this;
/*  319 */     Map<Long, Integer> roleid2state = new HashMap();
/*  320 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2state.entrySet())
/*  321 */       roleid2state.put(_e_.getKey(), _e_.getValue());
/*  322 */     return roleid2state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSource()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return this.source;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.roleBattleData> getRolebattledatas()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return xdb.Logs.logMap(new LogKey(this, "rolebattledatas"), this.rolebattledatas);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.roleBattleData> getRolebattledatasAsData()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*      */     
/*  347 */     CampInfo _o_ = this;
/*  348 */     Map<Long, xbean.roleBattleData> rolebattledatas = new HashMap();
/*  349 */     for (Map.Entry<Long, xbean.roleBattleData> _e_ : _o_.rolebattledatas.entrySet())
/*  350 */       rolebattledatas.put(_e_.getKey(), new roleBattleData.Data((xbean.roleBattleData)_e_.getValue()));
/*  351 */     return rolebattledatas;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getSurrender()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return this.surrender;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSource(int _v_)
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     xdb.Logs.logIf(new LogKey(this, "source")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  371 */         new xdb.logs.LogInt(this, CampInfo.this.source)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  375 */             CampInfo.this.source = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  379 */     });
/*  380 */     this.source = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSurrender(boolean _v_)
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     xdb.Logs.logIf(new LogKey(this, "surrender")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  392 */         new xdb.logs.LogObject(this, Boolean.valueOf(CampInfo.this.surrender))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  396 */             CampInfo.this.surrender = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  400 */     });
/*  401 */     this.surrender = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     CampInfo _o_ = null;
/*  409 */     if ((_o1_ instanceof CampInfo)) { _o_ = (CampInfo)_o1_;
/*  410 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  411 */       return false;
/*  412 */     if (!this.roleid2state.equals(_o_.roleid2state)) return false;
/*  413 */     if (this.source != _o_.source) return false;
/*  414 */     if (!this.rolebattledatas.equals(_o_.rolebattledatas)) return false;
/*  415 */     if (this.surrender != _o_.surrender) return false;
/*  416 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     int _h_ = 0;
/*  424 */     _h_ += this.roleid2state.hashCode();
/*  425 */     _h_ += this.source;
/*  426 */     _h_ += this.rolebattledatas.hashCode();
/*  427 */     _h_ += (this.surrender ? 1231 : 1237);
/*  428 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  434 */     _xdb_verify_unsafe_();
/*  435 */     StringBuilder _sb_ = new StringBuilder();
/*  436 */     _sb_.append("(");
/*  437 */     _sb_.append(this.roleid2state);
/*  438 */     _sb_.append(",");
/*  439 */     _sb_.append(this.source);
/*  440 */     _sb_.append(",");
/*  441 */     _sb_.append(this.rolebattledatas);
/*  442 */     _sb_.append(",");
/*  443 */     _sb_.append(this.surrender);
/*  444 */     _sb_.append(")");
/*  445 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  451 */     ListenableBean lb = new ListenableBean();
/*  452 */     lb.add(new xdb.logs.ListenableMap().setVarName("roleid2state"));
/*  453 */     lb.add(new xdb.logs.ListenableChanged().setVarName("source"));
/*  454 */     lb.add(new xdb.logs.ListenableMap().setVarName("rolebattledatas"));
/*  455 */     lb.add(new xdb.logs.ListenableChanged().setVarName("surrender"));
/*  456 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CampInfo {
/*      */     private Const() {}
/*      */     
/*      */     CampInfo nThis() {
/*  463 */       return CampInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  469 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CampInfo copy()
/*      */     {
/*  475 */       return CampInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CampInfo toData()
/*      */     {
/*  481 */       return CampInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CampInfo toBean()
/*      */     {
/*  486 */       return CampInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CampInfo toDataIf()
/*      */     {
/*  492 */       return CampInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CampInfo toBeanIf()
/*      */     {
/*  497 */       return CampInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoleid2state()
/*      */     {
/*  504 */       CampInfo.this._xdb_verify_unsafe_();
/*  505 */       return xdb.Consts.constMap(CampInfo.this.roleid2state);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoleid2stateAsData()
/*      */     {
/*  512 */       CampInfo.this._xdb_verify_unsafe_();
/*      */       
/*  514 */       CampInfo _o_ = CampInfo.this;
/*  515 */       Map<Long, Integer> roleid2state = new HashMap();
/*  516 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2state.entrySet())
/*  517 */         roleid2state.put(_e_.getKey(), _e_.getValue());
/*  518 */       return roleid2state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSource()
/*      */     {
/*  525 */       CampInfo.this._xdb_verify_unsafe_();
/*  526 */       return CampInfo.this.source;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.roleBattleData> getRolebattledatas()
/*      */     {
/*  533 */       CampInfo.this._xdb_verify_unsafe_();
/*  534 */       return xdb.Consts.constMap(CampInfo.this.rolebattledatas);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.roleBattleData> getRolebattledatasAsData()
/*      */     {
/*  541 */       CampInfo.this._xdb_verify_unsafe_();
/*      */       
/*  543 */       CampInfo _o_ = CampInfo.this;
/*  544 */       Map<Long, xbean.roleBattleData> rolebattledatas = new HashMap();
/*  545 */       for (Map.Entry<Long, xbean.roleBattleData> _e_ : _o_.rolebattledatas.entrySet())
/*  546 */         rolebattledatas.put(_e_.getKey(), new roleBattleData.Data((xbean.roleBattleData)_e_.getValue()));
/*  547 */       return rolebattledatas;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getSurrender()
/*      */     {
/*  554 */       CampInfo.this._xdb_verify_unsafe_();
/*  555 */       return CampInfo.this.surrender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSource(int _v_)
/*      */     {
/*  562 */       CampInfo.this._xdb_verify_unsafe_();
/*  563 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSurrender(boolean _v_)
/*      */     {
/*  570 */       CampInfo.this._xdb_verify_unsafe_();
/*  571 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  577 */       CampInfo.this._xdb_verify_unsafe_();
/*  578 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  584 */       CampInfo.this._xdb_verify_unsafe_();
/*  585 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  591 */       return CampInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  597 */       return CampInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  603 */       CampInfo.this._xdb_verify_unsafe_();
/*  604 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  610 */       return CampInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  616 */       return CampInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  622 */       CampInfo.this._xdb_verify_unsafe_();
/*  623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  629 */       return CampInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  635 */       return CampInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  641 */       return CampInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  647 */       return CampInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  653 */       return CampInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  659 */       return CampInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  665 */       return CampInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CampInfo
/*      */   {
/*      */     private HashMap<Long, Integer> roleid2state;
/*      */     
/*      */     private int source;
/*      */     
/*      */     private HashMap<Long, xbean.roleBattleData> rolebattledatas;
/*      */     
/*      */     private boolean surrender;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  683 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  688 */       this.roleid2state = new HashMap();
/*  689 */       this.rolebattledatas = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.CampInfo _o1_)
/*      */     {
/*  694 */       if ((_o1_ instanceof CampInfo)) { assign((CampInfo)_o1_);
/*  695 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  696 */       } else if ((_o1_ instanceof CampInfo.Const)) assign(((CampInfo.Const)_o1_).nThis()); else {
/*  697 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CampInfo _o_) {
/*  702 */       this.roleid2state = new HashMap();
/*  703 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2state.entrySet())
/*  704 */         this.roleid2state.put(_e_.getKey(), _e_.getValue());
/*  705 */       this.source = _o_.source;
/*  706 */       this.rolebattledatas = new HashMap();
/*  707 */       for (Map.Entry<Long, xbean.roleBattleData> _e_ : _o_.rolebattledatas.entrySet())
/*  708 */         this.rolebattledatas.put(_e_.getKey(), new roleBattleData.Data((xbean.roleBattleData)_e_.getValue()));
/*  709 */       this.surrender = _o_.surrender;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  714 */       this.roleid2state = new HashMap();
/*  715 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2state.entrySet())
/*  716 */         this.roleid2state.put(_e_.getKey(), _e_.getValue());
/*  717 */       this.source = _o_.source;
/*  718 */       this.rolebattledatas = new HashMap();
/*  719 */       for (Map.Entry<Long, xbean.roleBattleData> _e_ : _o_.rolebattledatas.entrySet())
/*  720 */         this.rolebattledatas.put(_e_.getKey(), new roleBattleData.Data((xbean.roleBattleData)_e_.getValue()));
/*  721 */       this.surrender = _o_.surrender;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  727 */       _os_.compact_uint32(this.roleid2state.size());
/*  728 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2state.entrySet())
/*      */       {
/*  730 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  731 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  733 */       _os_.marshal(this.source);
/*  734 */       _os_.compact_uint32(this.rolebattledatas.size());
/*  735 */       for (Map.Entry<Long, xbean.roleBattleData> _e_ : this.rolebattledatas.entrySet())
/*      */       {
/*  737 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  738 */         ((xbean.roleBattleData)_e_.getValue()).marshal(_os_);
/*      */       }
/*  740 */       _os_.marshal(this.surrender);
/*  741 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  748 */       int size = _os_.uncompact_uint32();
/*  749 */       if (size >= 12)
/*      */       {
/*  751 */         this.roleid2state = new HashMap(size * 2);
/*      */       }
/*  753 */       for (; size > 0; size--)
/*      */       {
/*  755 */         long _k_ = 0L;
/*  756 */         _k_ = _os_.unmarshal_long();
/*  757 */         int _v_ = 0;
/*  758 */         _v_ = _os_.unmarshal_int();
/*  759 */         this.roleid2state.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  762 */       this.source = _os_.unmarshal_int();
/*      */       
/*  764 */       int size = _os_.uncompact_uint32();
/*  765 */       if (size >= 12)
/*      */       {
/*  767 */         this.rolebattledatas = new HashMap(size * 2);
/*      */       }
/*  769 */       for (; size > 0; size--)
/*      */       {
/*  771 */         long _k_ = 0L;
/*  772 */         _k_ = _os_.unmarshal_long();
/*  773 */         xbean.roleBattleData _v_ = xbean.Pod.newroleBattleDataData();
/*  774 */         _v_.unmarshal(_os_);
/*  775 */         this.rolebattledatas.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  778 */       this.surrender = _os_.unmarshal_boolean();
/*  779 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  785 */       int _size_ = 0;
/*  786 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2state.entrySet())
/*      */       {
/*  788 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  789 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  791 */       _size_ += CodedOutputStream.computeInt32Size(2, this.source);
/*  792 */       for (Map.Entry<Long, xbean.roleBattleData> _e_ : this.rolebattledatas.entrySet())
/*      */       {
/*  794 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  795 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  797 */       _size_ += CodedOutputStream.computeBoolSize(4, this.surrender);
/*  798 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  806 */         for (Map.Entry<Long, Integer> _e_ : this.roleid2state.entrySet())
/*      */         {
/*  808 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  809 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  811 */         _output_.writeInt32(2, this.source);
/*  812 */         for (Map.Entry<Long, xbean.roleBattleData> _e_ : this.rolebattledatas.entrySet())
/*      */         {
/*  814 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  815 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */         }
/*  817 */         _output_.writeBool(4, this.surrender);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  821 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  823 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  831 */         boolean done = false;
/*  832 */         while (!done)
/*      */         {
/*  834 */           int tag = _input_.readTag();
/*  835 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  839 */             done = true;
/*  840 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  844 */             long _k_ = 0L;
/*  845 */             _k_ = _input_.readInt64();
/*  846 */             int readTag = _input_.readTag();
/*  847 */             if (8 != readTag)
/*      */             {
/*  849 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  851 */             int _v_ = 0;
/*  852 */             _v_ = _input_.readInt32();
/*  853 */             this.roleid2state.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  854 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  858 */             this.source = _input_.readInt32();
/*  859 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  863 */             long _k_ = 0L;
/*  864 */             _k_ = _input_.readInt64();
/*  865 */             int readTag = _input_.readTag();
/*  866 */             if (26 != readTag)
/*      */             {
/*  868 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  870 */             xbean.roleBattleData _v_ = xbean.Pod.newroleBattleDataData();
/*  871 */             _input_.readMessage(_v_);
/*  872 */             this.rolebattledatas.put(Long.valueOf(_k_), _v_);
/*  873 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  877 */             this.surrender = _input_.readBool();
/*  878 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  882 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  884 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  893 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  897 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  899 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CampInfo copy()
/*      */     {
/*  905 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CampInfo toData()
/*      */     {
/*  911 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CampInfo toBean()
/*      */     {
/*  916 */       return new CampInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CampInfo toDataIf()
/*      */     {
/*  922 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CampInfo toBeanIf()
/*      */     {
/*  927 */       return new CampInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  949 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  953 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  957 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoleid2state()
/*      */     {
/*  964 */       return this.roleid2state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoleid2stateAsData()
/*      */     {
/*  971 */       return this.roleid2state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSource()
/*      */     {
/*  978 */       return this.source;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.roleBattleData> getRolebattledatas()
/*      */     {
/*  985 */       return this.rolebattledatas;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.roleBattleData> getRolebattledatasAsData()
/*      */     {
/*  992 */       return this.rolebattledatas;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getSurrender()
/*      */     {
/*  999 */       return this.surrender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSource(int _v_)
/*      */     {
/* 1006 */       this.source = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSurrender(boolean _v_)
/*      */     {
/* 1013 */       this.surrender = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1019 */       if (!(_o1_ instanceof Data)) return false;
/* 1020 */       Data _o_ = (Data)_o1_;
/* 1021 */       if (!this.roleid2state.equals(_o_.roleid2state)) return false;
/* 1022 */       if (this.source != _o_.source) return false;
/* 1023 */       if (!this.rolebattledatas.equals(_o_.rolebattledatas)) return false;
/* 1024 */       if (this.surrender != _o_.surrender) return false;
/* 1025 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1031 */       int _h_ = 0;
/* 1032 */       _h_ += this.roleid2state.hashCode();
/* 1033 */       _h_ += this.source;
/* 1034 */       _h_ += this.rolebattledatas.hashCode();
/* 1035 */       _h_ += (this.surrender ? 1231 : 1237);
/* 1036 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1042 */       StringBuilder _sb_ = new StringBuilder();
/* 1043 */       _sb_.append("(");
/* 1044 */       _sb_.append(this.roleid2state);
/* 1045 */       _sb_.append(",");
/* 1046 */       _sb_.append(this.source);
/* 1047 */       _sb_.append(",");
/* 1048 */       _sb_.append(this.rolebattledatas);
/* 1049 */       _sb_.append(",");
/* 1050 */       _sb_.append(this.surrender);
/* 1051 */       _sb_.append(")");
/* 1052 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CampInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */