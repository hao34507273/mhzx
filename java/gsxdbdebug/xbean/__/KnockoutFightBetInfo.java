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
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class KnockoutFightBetInfo extends XBean implements xbean.KnockoutFightBetInfo
/*      */ {
/*      */   private long a_corps_id;
/*      */   private long b_corps_id;
/*      */   private int cal_fight_result;
/*      */   private boolean has_set_cal_fight_result;
/*      */   private HashMap<Long, xbean.RoleKnockoutFightBetInfo> role_bet_infos;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.a_corps_id = 0L;
/*   27 */     this.b_corps_id = 0L;
/*   28 */     this.cal_fight_result = 0;
/*   29 */     this.has_set_cal_fight_result = false;
/*   30 */     this.role_bet_infos.clear();
/*      */   }
/*      */   
/*      */   KnockoutFightBetInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.a_corps_id = 0L;
/*   37 */     this.b_corps_id = 0L;
/*   38 */     this.cal_fight_result = 0;
/*   39 */     this.has_set_cal_fight_result = false;
/*   40 */     this.role_bet_infos = new HashMap();
/*      */   }
/*      */   
/*      */   public KnockoutFightBetInfo()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public KnockoutFightBetInfo(KnockoutFightBetInfo _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   KnockoutFightBetInfo(xbean.KnockoutFightBetInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof KnockoutFightBetInfo)) { assign((KnockoutFightBetInfo)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(KnockoutFightBetInfo _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.a_corps_id = _o_.a_corps_id;
/*   66 */     this.b_corps_id = _o_.b_corps_id;
/*   67 */     this.cal_fight_result = _o_.cal_fight_result;
/*   68 */     this.has_set_cal_fight_result = _o_.has_set_cal_fight_result;
/*   69 */     this.role_bet_infos = new HashMap();
/*   70 */     for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : _o_.role_bet_infos.entrySet()) {
/*   71 */       this.role_bet_infos.put(_e_.getKey(), new RoleKnockoutFightBetInfo((xbean.RoleKnockoutFightBetInfo)_e_.getValue(), this, "role_bet_infos"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   76 */     this.a_corps_id = _o_.a_corps_id;
/*   77 */     this.b_corps_id = _o_.b_corps_id;
/*   78 */     this.cal_fight_result = _o_.cal_fight_result;
/*   79 */     this.has_set_cal_fight_result = _o_.has_set_cal_fight_result;
/*   80 */     this.role_bet_infos = new HashMap();
/*   81 */     for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : _o_.role_bet_infos.entrySet()) {
/*   82 */       this.role_bet_infos.put(_e_.getKey(), new RoleKnockoutFightBetInfo((xbean.RoleKnockoutFightBetInfo)_e_.getValue(), this, "role_bet_infos"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   88 */     _xdb_verify_unsafe_();
/*   89 */     _os_.marshal(this.a_corps_id);
/*   90 */     _os_.marshal(this.b_corps_id);
/*   91 */     _os_.marshal(this.cal_fight_result);
/*   92 */     _os_.marshal(this.has_set_cal_fight_result);
/*   93 */     _os_.compact_uint32(this.role_bet_infos.size());
/*   94 */     for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */     {
/*   96 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   97 */       ((xbean.RoleKnockoutFightBetInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     this.a_corps_id = _os_.unmarshal_long();
/*  107 */     this.b_corps_id = _os_.unmarshal_long();
/*  108 */     this.cal_fight_result = _os_.unmarshal_int();
/*  109 */     this.has_set_cal_fight_result = _os_.unmarshal_boolean();
/*      */     
/*  111 */     int size = _os_.uncompact_uint32();
/*  112 */     if (size >= 12)
/*      */     {
/*  114 */       this.role_bet_infos = new HashMap(size * 2);
/*      */     }
/*  116 */     for (; size > 0; size--)
/*      */     {
/*  118 */       long _k_ = 0L;
/*  119 */       _k_ = _os_.unmarshal_long();
/*  120 */       xbean.RoleKnockoutFightBetInfo _v_ = new RoleKnockoutFightBetInfo(0, this, "role_bet_infos");
/*  121 */       _v_.unmarshal(_os_);
/*  122 */       this.role_bet_infos.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  125 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  131 */     _xdb_verify_unsafe_();
/*  132 */     int _size_ = 0;
/*  133 */     _size_ += CodedOutputStream.computeInt64Size(1, this.a_corps_id);
/*  134 */     _size_ += CodedOutputStream.computeInt64Size(2, this.b_corps_id);
/*  135 */     _size_ += CodedOutputStream.computeInt32Size(3, this.cal_fight_result);
/*  136 */     _size_ += CodedOutputStream.computeBoolSize(4, this.has_set_cal_fight_result);
/*  137 */     for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */     {
/*  139 */       _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  140 */       _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */     }
/*  142 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  148 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  151 */       _output_.writeInt64(1, this.a_corps_id);
/*  152 */       _output_.writeInt64(2, this.b_corps_id);
/*  153 */       _output_.writeInt32(3, this.cal_fight_result);
/*  154 */       _output_.writeBool(4, this.has_set_cal_fight_result);
/*  155 */       for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */       {
/*  157 */         _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  158 */         _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  165 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  171 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  174 */       boolean done = false;
/*  175 */       while (!done)
/*      */       {
/*  177 */         int tag = _input_.readTag();
/*  178 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  182 */           done = true;
/*  183 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  187 */           this.a_corps_id = _input_.readInt64();
/*  188 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  192 */           this.b_corps_id = _input_.readInt64();
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  197 */           this.cal_fight_result = _input_.readInt32();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  202 */           this.has_set_cal_fight_result = _input_.readBool();
/*  203 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  207 */           long _k_ = 0L;
/*  208 */           _k_ = _input_.readInt64();
/*  209 */           int readTag = _input_.readTag();
/*  210 */           if (42 != readTag)
/*      */           {
/*  212 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  214 */           xbean.RoleKnockoutFightBetInfo _v_ = new RoleKnockoutFightBetInfo(0, this, "role_bet_infos");
/*  215 */           _input_.readMessage(_v_);
/*  216 */           this.role_bet_infos.put(Long.valueOf(_k_), _v_);
/*  217 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  221 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  223 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  232 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  236 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  238 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.KnockoutFightBetInfo copy()
/*      */   {
/*  244 */     _xdb_verify_unsafe_();
/*  245 */     return new KnockoutFightBetInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.KnockoutFightBetInfo toData()
/*      */   {
/*  251 */     _xdb_verify_unsafe_();
/*  252 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.KnockoutFightBetInfo toBean()
/*      */   {
/*  257 */     _xdb_verify_unsafe_();
/*  258 */     return new KnockoutFightBetInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.KnockoutFightBetInfo toDataIf()
/*      */   {
/*  264 */     _xdb_verify_unsafe_();
/*  265 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.KnockoutFightBetInfo toBeanIf()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getA_corps_id()
/*      */   {
/*  285 */     _xdb_verify_unsafe_();
/*  286 */     return this.a_corps_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getB_corps_id()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return this.b_corps_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCal_fight_result()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return this.cal_fight_result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getHas_set_cal_fight_result()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return this.has_set_cal_fight_result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RoleKnockoutFightBetInfo> getRole_bet_infos()
/*      */   {
/*  317 */     _xdb_verify_unsafe_();
/*  318 */     return xdb.Logs.logMap(new LogKey(this, "role_bet_infos"), this.role_bet_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RoleKnockoutFightBetInfo> getRole_bet_infosAsData()
/*      */   {
/*  325 */     _xdb_verify_unsafe_();
/*      */     
/*  327 */     KnockoutFightBetInfo _o_ = this;
/*  328 */     Map<Long, xbean.RoleKnockoutFightBetInfo> role_bet_infos = new HashMap();
/*  329 */     for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : _o_.role_bet_infos.entrySet())
/*  330 */       role_bet_infos.put(_e_.getKey(), new RoleKnockoutFightBetInfo.Data((xbean.RoleKnockoutFightBetInfo)_e_.getValue()));
/*  331 */     return role_bet_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setA_corps_id(long _v_)
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     xdb.Logs.logIf(new LogKey(this, "a_corps_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  343 */         new xdb.logs.LogLong(this, KnockoutFightBetInfo.this.a_corps_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  347 */             KnockoutFightBetInfo.this.a_corps_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  351 */     });
/*  352 */     this.a_corps_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setB_corps_id(long _v_)
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     xdb.Logs.logIf(new LogKey(this, "b_corps_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  364 */         new xdb.logs.LogLong(this, KnockoutFightBetInfo.this.b_corps_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  368 */             KnockoutFightBetInfo.this.b_corps_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  372 */     });
/*  373 */     this.b_corps_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCal_fight_result(int _v_)
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     xdb.Logs.logIf(new LogKey(this, "cal_fight_result")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  385 */         new xdb.logs.LogInt(this, KnockoutFightBetInfo.this.cal_fight_result)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  389 */             KnockoutFightBetInfo.this.cal_fight_result = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  393 */     });
/*  394 */     this.cal_fight_result = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHas_set_cal_fight_result(boolean _v_)
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     xdb.Logs.logIf(new LogKey(this, "has_set_cal_fight_result")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  406 */         new xdb.logs.LogObject(this, Boolean.valueOf(KnockoutFightBetInfo.this.has_set_cal_fight_result))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  410 */             KnockoutFightBetInfo.this.has_set_cal_fight_result = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  414 */     });
/*  415 */     this.has_set_cal_fight_result = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     KnockoutFightBetInfo _o_ = null;
/*  423 */     if ((_o1_ instanceof KnockoutFightBetInfo)) { _o_ = (KnockoutFightBetInfo)_o1_;
/*  424 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  425 */       return false;
/*  426 */     if (this.a_corps_id != _o_.a_corps_id) return false;
/*  427 */     if (this.b_corps_id != _o_.b_corps_id) return false;
/*  428 */     if (this.cal_fight_result != _o_.cal_fight_result) return false;
/*  429 */     if (this.has_set_cal_fight_result != _o_.has_set_cal_fight_result) return false;
/*  430 */     if (!this.role_bet_infos.equals(_o_.role_bet_infos)) return false;
/*  431 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*  438 */     int _h_ = 0;
/*  439 */     _h_ = (int)(_h_ + this.a_corps_id);
/*  440 */     _h_ = (int)(_h_ + this.b_corps_id);
/*  441 */     _h_ += this.cal_fight_result;
/*  442 */     _h_ += (this.has_set_cal_fight_result ? 1231 : 1237);
/*  443 */     _h_ += this.role_bet_infos.hashCode();
/*  444 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     StringBuilder _sb_ = new StringBuilder();
/*  452 */     _sb_.append("(");
/*  453 */     _sb_.append(this.a_corps_id);
/*  454 */     _sb_.append(",");
/*  455 */     _sb_.append(this.b_corps_id);
/*  456 */     _sb_.append(",");
/*  457 */     _sb_.append(this.cal_fight_result);
/*  458 */     _sb_.append(",");
/*  459 */     _sb_.append(this.has_set_cal_fight_result);
/*  460 */     _sb_.append(",");
/*  461 */     _sb_.append(this.role_bet_infos);
/*  462 */     _sb_.append(")");
/*  463 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  469 */     ListenableBean lb = new ListenableBean();
/*  470 */     lb.add(new ListenableChanged().setVarName("a_corps_id"));
/*  471 */     lb.add(new ListenableChanged().setVarName("b_corps_id"));
/*  472 */     lb.add(new ListenableChanged().setVarName("cal_fight_result"));
/*  473 */     lb.add(new ListenableChanged().setVarName("has_set_cal_fight_result"));
/*  474 */     lb.add(new xdb.logs.ListenableMap().setVarName("role_bet_infos"));
/*  475 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.KnockoutFightBetInfo {
/*      */     private Const() {}
/*      */     
/*      */     KnockoutFightBetInfo nThis() {
/*  482 */       return KnockoutFightBetInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  488 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KnockoutFightBetInfo copy()
/*      */     {
/*  494 */       return KnockoutFightBetInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KnockoutFightBetInfo toData()
/*      */     {
/*  500 */       return KnockoutFightBetInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.KnockoutFightBetInfo toBean()
/*      */     {
/*  505 */       return KnockoutFightBetInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KnockoutFightBetInfo toDataIf()
/*      */     {
/*  511 */       return KnockoutFightBetInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.KnockoutFightBetInfo toBeanIf()
/*      */     {
/*  516 */       return KnockoutFightBetInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getA_corps_id()
/*      */     {
/*  523 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  524 */       return KnockoutFightBetInfo.this.a_corps_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getB_corps_id()
/*      */     {
/*  531 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  532 */       return KnockoutFightBetInfo.this.b_corps_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCal_fight_result()
/*      */     {
/*  539 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  540 */       return KnockoutFightBetInfo.this.cal_fight_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHas_set_cal_fight_result()
/*      */     {
/*  547 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  548 */       return KnockoutFightBetInfo.this.has_set_cal_fight_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleKnockoutFightBetInfo> getRole_bet_infos()
/*      */     {
/*  555 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  556 */       return xdb.Consts.constMap(KnockoutFightBetInfo.this.role_bet_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleKnockoutFightBetInfo> getRole_bet_infosAsData()
/*      */     {
/*  563 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*      */       
/*  565 */       KnockoutFightBetInfo _o_ = KnockoutFightBetInfo.this;
/*  566 */       Map<Long, xbean.RoleKnockoutFightBetInfo> role_bet_infos = new HashMap();
/*  567 */       for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : _o_.role_bet_infos.entrySet())
/*  568 */         role_bet_infos.put(_e_.getKey(), new RoleKnockoutFightBetInfo.Data((xbean.RoleKnockoutFightBetInfo)_e_.getValue()));
/*  569 */       return role_bet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setA_corps_id(long _v_)
/*      */     {
/*  576 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  577 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setB_corps_id(long _v_)
/*      */     {
/*  584 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  585 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCal_fight_result(int _v_)
/*      */     {
/*  592 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  593 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHas_set_cal_fight_result(boolean _v_)
/*      */     {
/*  600 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  601 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  607 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  608 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  614 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  615 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  621 */       return KnockoutFightBetInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  627 */       return KnockoutFightBetInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  633 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  634 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  640 */       return KnockoutFightBetInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  646 */       return KnockoutFightBetInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  652 */       KnockoutFightBetInfo.this._xdb_verify_unsafe_();
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  659 */       return KnockoutFightBetInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  665 */       return KnockoutFightBetInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  671 */       return KnockoutFightBetInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  677 */       return KnockoutFightBetInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  683 */       return KnockoutFightBetInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  689 */       return KnockoutFightBetInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  695 */       return KnockoutFightBetInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.KnockoutFightBetInfo
/*      */   {
/*      */     private long a_corps_id;
/*      */     
/*      */     private long b_corps_id;
/*      */     
/*      */     private int cal_fight_result;
/*      */     
/*      */     private boolean has_set_cal_fight_result;
/*      */     
/*      */     private HashMap<Long, xbean.RoleKnockoutFightBetInfo> role_bet_infos;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  715 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  720 */       this.a_corps_id = 0L;
/*  721 */       this.b_corps_id = 0L;
/*  722 */       this.cal_fight_result = 0;
/*  723 */       this.has_set_cal_fight_result = false;
/*  724 */       this.role_bet_infos = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.KnockoutFightBetInfo _o1_)
/*      */     {
/*  729 */       if ((_o1_ instanceof KnockoutFightBetInfo)) { assign((KnockoutFightBetInfo)_o1_);
/*  730 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  731 */       } else if ((_o1_ instanceof KnockoutFightBetInfo.Const)) assign(((KnockoutFightBetInfo.Const)_o1_).nThis()); else {
/*  732 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(KnockoutFightBetInfo _o_) {
/*  737 */       this.a_corps_id = _o_.a_corps_id;
/*  738 */       this.b_corps_id = _o_.b_corps_id;
/*  739 */       this.cal_fight_result = _o_.cal_fight_result;
/*  740 */       this.has_set_cal_fight_result = _o_.has_set_cal_fight_result;
/*  741 */       this.role_bet_infos = new HashMap();
/*  742 */       for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : _o_.role_bet_infos.entrySet()) {
/*  743 */         this.role_bet_infos.put(_e_.getKey(), new RoleKnockoutFightBetInfo.Data((xbean.RoleKnockoutFightBetInfo)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  748 */       this.a_corps_id = _o_.a_corps_id;
/*  749 */       this.b_corps_id = _o_.b_corps_id;
/*  750 */       this.cal_fight_result = _o_.cal_fight_result;
/*  751 */       this.has_set_cal_fight_result = _o_.has_set_cal_fight_result;
/*  752 */       this.role_bet_infos = new HashMap();
/*  753 */       for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : _o_.role_bet_infos.entrySet()) {
/*  754 */         this.role_bet_infos.put(_e_.getKey(), new RoleKnockoutFightBetInfo.Data((xbean.RoleKnockoutFightBetInfo)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  760 */       _os_.marshal(this.a_corps_id);
/*  761 */       _os_.marshal(this.b_corps_id);
/*  762 */       _os_.marshal(this.cal_fight_result);
/*  763 */       _os_.marshal(this.has_set_cal_fight_result);
/*  764 */       _os_.compact_uint32(this.role_bet_infos.size());
/*  765 */       for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */       {
/*  767 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  768 */         ((xbean.RoleKnockoutFightBetInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  770 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  776 */       this.a_corps_id = _os_.unmarshal_long();
/*  777 */       this.b_corps_id = _os_.unmarshal_long();
/*  778 */       this.cal_fight_result = _os_.unmarshal_int();
/*  779 */       this.has_set_cal_fight_result = _os_.unmarshal_boolean();
/*      */       
/*  781 */       int size = _os_.uncompact_uint32();
/*  782 */       if (size >= 12)
/*      */       {
/*  784 */         this.role_bet_infos = new HashMap(size * 2);
/*      */       }
/*  786 */       for (; size > 0; size--)
/*      */       {
/*  788 */         long _k_ = 0L;
/*  789 */         _k_ = _os_.unmarshal_long();
/*  790 */         xbean.RoleKnockoutFightBetInfo _v_ = xbean.Pod.newRoleKnockoutFightBetInfoData();
/*  791 */         _v_.unmarshal(_os_);
/*  792 */         this.role_bet_infos.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  795 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  801 */       int _size_ = 0;
/*  802 */       _size_ += CodedOutputStream.computeInt64Size(1, this.a_corps_id);
/*  803 */       _size_ += CodedOutputStream.computeInt64Size(2, this.b_corps_id);
/*  804 */       _size_ += CodedOutputStream.computeInt32Size(3, this.cal_fight_result);
/*  805 */       _size_ += CodedOutputStream.computeBoolSize(4, this.has_set_cal_fight_result);
/*  806 */       for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */       {
/*  808 */         _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  809 */         _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*  811 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  819 */         _output_.writeInt64(1, this.a_corps_id);
/*  820 */         _output_.writeInt64(2, this.b_corps_id);
/*  821 */         _output_.writeInt32(3, this.cal_fight_result);
/*  822 */         _output_.writeBool(4, this.has_set_cal_fight_result);
/*  823 */         for (Map.Entry<Long, xbean.RoleKnockoutFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */         {
/*  825 */           _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  826 */           _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  831 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  833 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  841 */         boolean done = false;
/*  842 */         while (!done)
/*      */         {
/*  844 */           int tag = _input_.readTag();
/*  845 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  849 */             done = true;
/*  850 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  854 */             this.a_corps_id = _input_.readInt64();
/*  855 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  859 */             this.b_corps_id = _input_.readInt64();
/*  860 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  864 */             this.cal_fight_result = _input_.readInt32();
/*  865 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  869 */             this.has_set_cal_fight_result = _input_.readBool();
/*  870 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  874 */             long _k_ = 0L;
/*  875 */             _k_ = _input_.readInt64();
/*  876 */             int readTag = _input_.readTag();
/*  877 */             if (42 != readTag)
/*      */             {
/*  879 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  881 */             xbean.RoleKnockoutFightBetInfo _v_ = xbean.Pod.newRoleKnockoutFightBetInfoData();
/*  882 */             _input_.readMessage(_v_);
/*  883 */             this.role_bet_infos.put(Long.valueOf(_k_), _v_);
/*  884 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  888 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  890 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  899 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  903 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  905 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KnockoutFightBetInfo copy()
/*      */     {
/*  911 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KnockoutFightBetInfo toData()
/*      */     {
/*  917 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.KnockoutFightBetInfo toBean()
/*      */     {
/*  922 */       return new KnockoutFightBetInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.KnockoutFightBetInfo toDataIf()
/*      */     {
/*  928 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.KnockoutFightBetInfo toBeanIf()
/*      */     {
/*  933 */       return new KnockoutFightBetInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  943 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  951 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  955 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  959 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  963 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getA_corps_id()
/*      */     {
/*  970 */       return this.a_corps_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getB_corps_id()
/*      */     {
/*  977 */       return this.b_corps_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCal_fight_result()
/*      */     {
/*  984 */       return this.cal_fight_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHas_set_cal_fight_result()
/*      */     {
/*  991 */       return this.has_set_cal_fight_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleKnockoutFightBetInfo> getRole_bet_infos()
/*      */     {
/*  998 */       return this.role_bet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleKnockoutFightBetInfo> getRole_bet_infosAsData()
/*      */     {
/* 1005 */       return this.role_bet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setA_corps_id(long _v_)
/*      */     {
/* 1012 */       this.a_corps_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setB_corps_id(long _v_)
/*      */     {
/* 1019 */       this.b_corps_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCal_fight_result(int _v_)
/*      */     {
/* 1026 */       this.cal_fight_result = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHas_set_cal_fight_result(boolean _v_)
/*      */     {
/* 1033 */       this.has_set_cal_fight_result = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1039 */       if (!(_o1_ instanceof Data)) return false;
/* 1040 */       Data _o_ = (Data)_o1_;
/* 1041 */       if (this.a_corps_id != _o_.a_corps_id) return false;
/* 1042 */       if (this.b_corps_id != _o_.b_corps_id) return false;
/* 1043 */       if (this.cal_fight_result != _o_.cal_fight_result) return false;
/* 1044 */       if (this.has_set_cal_fight_result != _o_.has_set_cal_fight_result) return false;
/* 1045 */       if (!this.role_bet_infos.equals(_o_.role_bet_infos)) return false;
/* 1046 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1052 */       int _h_ = 0;
/* 1053 */       _h_ = (int)(_h_ + this.a_corps_id);
/* 1054 */       _h_ = (int)(_h_ + this.b_corps_id);
/* 1055 */       _h_ += this.cal_fight_result;
/* 1056 */       _h_ += (this.has_set_cal_fight_result ? 1231 : 1237);
/* 1057 */       _h_ += this.role_bet_infos.hashCode();
/* 1058 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1064 */       StringBuilder _sb_ = new StringBuilder();
/* 1065 */       _sb_.append("(");
/* 1066 */       _sb_.append(this.a_corps_id);
/* 1067 */       _sb_.append(",");
/* 1068 */       _sb_.append(this.b_corps_id);
/* 1069 */       _sb_.append(",");
/* 1070 */       _sb_.append(this.cal_fight_result);
/* 1071 */       _sb_.append(",");
/* 1072 */       _sb_.append(this.has_set_cal_fight_result);
/* 1073 */       _sb_.append(",");
/* 1074 */       _sb_.append(this.role_bet_infos);
/* 1075 */       _sb_.append(")");
/* 1076 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\KnockoutFightBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */