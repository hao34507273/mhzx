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
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class CrossbattlePointRaceInfo extends XBean implements xbean.CrossbattlePointRaceInfo
/*      */ {
/*      */   private int time_point_cfgid;
/*      */   private HashMap<Long, xbean.PointRaceInfo> corps;
/*      */   private HashMap<Long, Boolean> next_mailed;
/*      */   private ArrayList<Integer> backup_zones;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.time_point_cfgid = 0;
/*   25 */     this.corps.clear();
/*   26 */     this.next_mailed.clear();
/*   27 */     this.backup_zones.clear();
/*      */   }
/*      */   
/*      */   CrossbattlePointRaceInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.corps = new HashMap();
/*   34 */     this.next_mailed = new HashMap();
/*   35 */     this.backup_zones = new ArrayList();
/*      */   }
/*      */   
/*      */   public CrossbattlePointRaceInfo()
/*      */   {
/*   40 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CrossbattlePointRaceInfo(CrossbattlePointRaceInfo _o_)
/*      */   {
/*   45 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CrossbattlePointRaceInfo(xbean.CrossbattlePointRaceInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     if ((_o1_ instanceof CrossbattlePointRaceInfo)) { assign((CrossbattlePointRaceInfo)_o1_);
/*   52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   54 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CrossbattlePointRaceInfo _o_) {
/*   59 */     _o_._xdb_verify_unsafe_();
/*   60 */     this.time_point_cfgid = _o_.time_point_cfgid;
/*   61 */     this.corps = new HashMap();
/*   62 */     for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : _o_.corps.entrySet())
/*   63 */       this.corps.put(_e_.getKey(), new PointRaceInfo((xbean.PointRaceInfo)_e_.getValue(), this, "corps"));
/*   64 */     this.next_mailed = new HashMap();
/*   65 */     for (Map.Entry<Long, Boolean> _e_ : _o_.next_mailed.entrySet())
/*   66 */       this.next_mailed.put(_e_.getKey(), _e_.getValue());
/*   67 */     this.backup_zones = new ArrayList();
/*   68 */     this.backup_zones.addAll(_o_.backup_zones);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   73 */     this.time_point_cfgid = _o_.time_point_cfgid;
/*   74 */     this.corps = new HashMap();
/*   75 */     for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : _o_.corps.entrySet())
/*   76 */       this.corps.put(_e_.getKey(), new PointRaceInfo((xbean.PointRaceInfo)_e_.getValue(), this, "corps"));
/*   77 */     this.next_mailed = new HashMap();
/*   78 */     for (Map.Entry<Long, Boolean> _e_ : _o_.next_mailed.entrySet())
/*   79 */       this.next_mailed.put(_e_.getKey(), _e_.getValue());
/*   80 */     this.backup_zones = new ArrayList();
/*   81 */     this.backup_zones.addAll(_o_.backup_zones);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   87 */     _xdb_verify_unsafe_();
/*   88 */     _os_.marshal(this.time_point_cfgid);
/*   89 */     _os_.compact_uint32(this.corps.size());
/*   90 */     for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : this.corps.entrySet())
/*      */     {
/*   92 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   93 */       ((xbean.PointRaceInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*   95 */     _os_.compact_uint32(this.next_mailed.size());
/*   96 */     for (Map.Entry<Long, Boolean> _e_ : this.next_mailed.entrySet())
/*      */     {
/*   98 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   99 */       _os_.marshal(((Boolean)_e_.getValue()).booleanValue());
/*      */     }
/*  101 */     _os_.compact_uint32(this.backup_zones.size());
/*  102 */     for (Integer _v_ : this.backup_zones)
/*      */     {
/*  104 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     this.time_point_cfgid = _os_.unmarshal_int();
/*      */     
/*  115 */     int size = _os_.uncompact_uint32();
/*  116 */     if (size >= 12)
/*      */     {
/*  118 */       this.corps = new HashMap(size * 2);
/*      */     }
/*  120 */     for (; size > 0; size--)
/*      */     {
/*  122 */       long _k_ = 0L;
/*  123 */       _k_ = _os_.unmarshal_long();
/*  124 */       xbean.PointRaceInfo _v_ = new PointRaceInfo(0, this, "corps");
/*  125 */       _v_.unmarshal(_os_);
/*  126 */       this.corps.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  130 */     int size = _os_.uncompact_uint32();
/*  131 */     if (size >= 12)
/*      */     {
/*  133 */       this.next_mailed = new HashMap(size * 2);
/*      */     }
/*  135 */     for (; size > 0; size--)
/*      */     {
/*  137 */       long _k_ = 0L;
/*  138 */       _k_ = _os_.unmarshal_long();
/*  139 */       boolean _v_ = false;
/*  140 */       _v_ = _os_.unmarshal_boolean();
/*  141 */       this.next_mailed.put(Long.valueOf(_k_), Boolean.valueOf(_v_));
/*      */     }
/*      */     
/*  144 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  146 */       int _v_ = 0;
/*  147 */       _v_ = _os_.unmarshal_int();
/*  148 */       this.backup_zones.add(Integer.valueOf(_v_));
/*      */     }
/*  150 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  156 */     _xdb_verify_unsafe_();
/*  157 */     int _size_ = 0;
/*  158 */     _size_ += CodedOutputStream.computeInt32Size(1, this.time_point_cfgid);
/*  159 */     for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : this.corps.entrySet())
/*      */     {
/*  161 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  162 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */     }
/*  164 */     for (Map.Entry<Long, Boolean> _e_ : this.next_mailed.entrySet())
/*      */     {
/*  166 */       _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  167 */       _size_ += CodedOutputStream.computeBoolSize(5, ((Boolean)_e_.getValue()).booleanValue());
/*      */     }
/*  169 */     for (Integer _v_ : this.backup_zones)
/*      */     {
/*  171 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  173 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  179 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  182 */       _output_.writeInt32(1, this.time_point_cfgid);
/*  183 */       for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : this.corps.entrySet())
/*      */       {
/*  185 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  186 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  188 */       for (Map.Entry<Long, Boolean> _e_ : this.next_mailed.entrySet())
/*      */       {
/*  190 */         _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  191 */         _output_.writeBool(5, ((Boolean)_e_.getValue()).booleanValue());
/*      */       }
/*  193 */       for (Integer _v_ : this.backup_zones)
/*      */       {
/*  195 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  200 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  202 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  208 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  211 */       boolean done = false;
/*  212 */       while (!done)
/*      */       {
/*  214 */         int tag = _input_.readTag();
/*  215 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  219 */           done = true;
/*  220 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  224 */           this.time_point_cfgid = _input_.readInt32();
/*  225 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  229 */           long _k_ = 0L;
/*  230 */           _k_ = _input_.readInt64();
/*  231 */           int readTag = _input_.readTag();
/*  232 */           if (18 != readTag)
/*      */           {
/*  234 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  236 */           xbean.PointRaceInfo _v_ = new PointRaceInfo(0, this, "corps");
/*  237 */           _input_.readMessage(_v_);
/*  238 */           this.corps.put(Long.valueOf(_k_), _v_);
/*  239 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  243 */           long _k_ = 0L;
/*  244 */           _k_ = _input_.readInt64();
/*  245 */           int readTag = _input_.readTag();
/*  246 */           if (40 != readTag)
/*      */           {
/*  248 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  250 */           boolean _v_ = false;
/*  251 */           _v_ = _input_.readBool();
/*  252 */           this.next_mailed.put(Long.valueOf(_k_), Boolean.valueOf(_v_));
/*  253 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  257 */           int _v_ = 0;
/*  258 */           _v_ = _input_.readInt32();
/*  259 */           this.backup_zones.add(Integer.valueOf(_v_));
/*  260 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  264 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  266 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  275 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  279 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  281 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossbattlePointRaceInfo copy()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new CrossbattlePointRaceInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossbattlePointRaceInfo toData()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossbattlePointRaceInfo toBean()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return new CrossbattlePointRaceInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossbattlePointRaceInfo toDataIf()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossbattlePointRaceInfo toBeanIf()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTime_point_cfgid()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return this.time_point_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.PointRaceInfo> getCorps()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return xdb.Logs.logMap(new xdb.LogKey(this, "corps"), this.corps);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.PointRaceInfo> getCorpsAsData()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*      */     
/*  346 */     CrossbattlePointRaceInfo _o_ = this;
/*  347 */     Map<Long, xbean.PointRaceInfo> corps = new HashMap();
/*  348 */     for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : _o_.corps.entrySet())
/*  349 */       corps.put(_e_.getKey(), new PointRaceInfo.Data((xbean.PointRaceInfo)_e_.getValue()));
/*  350 */     return corps;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Boolean> getNext_mailed()
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     return xdb.Logs.logMap(new xdb.LogKey(this, "next_mailed"), this.next_mailed);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Boolean> getNext_mailedAsData()
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*      */     
/*  367 */     CrossbattlePointRaceInfo _o_ = this;
/*  368 */     Map<Long, Boolean> next_mailed = new HashMap();
/*  369 */     for (Map.Entry<Long, Boolean> _e_ : _o_.next_mailed.entrySet())
/*  370 */       next_mailed.put(_e_.getKey(), _e_.getValue());
/*  371 */     return next_mailed;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getBackup_zones()
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     return xdb.Logs.logList(new xdb.LogKey(this, "backup_zones"), this.backup_zones);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getBackup_zonesAsData()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*      */     
/*  387 */     CrossbattlePointRaceInfo _o_ = this;
/*  388 */     List<Integer> backup_zones = new ArrayList();
/*  389 */     backup_zones.addAll(_o_.backup_zones);
/*  390 */     return backup_zones;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTime_point_cfgid(int _v_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     xdb.Logs.logIf(new xdb.LogKey(this, "time_point_cfgid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  402 */         new xdb.logs.LogInt(this, CrossbattlePointRaceInfo.this.time_point_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  406 */             CrossbattlePointRaceInfo.this.time_point_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  410 */     });
/*  411 */     this.time_point_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     CrossbattlePointRaceInfo _o_ = null;
/*  419 */     if ((_o1_ instanceof CrossbattlePointRaceInfo)) { _o_ = (CrossbattlePointRaceInfo)_o1_;
/*  420 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  421 */       return false;
/*  422 */     if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/*  423 */     if (!this.corps.equals(_o_.corps)) return false;
/*  424 */     if (!this.next_mailed.equals(_o_.next_mailed)) return false;
/*  425 */     if (!this.backup_zones.equals(_o_.backup_zones)) return false;
/*  426 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*  433 */     int _h_ = 0;
/*  434 */     _h_ += this.time_point_cfgid;
/*  435 */     _h_ += this.corps.hashCode();
/*  436 */     _h_ += this.next_mailed.hashCode();
/*  437 */     _h_ += this.backup_zones.hashCode();
/*  438 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     StringBuilder _sb_ = new StringBuilder();
/*  446 */     _sb_.append("(");
/*  447 */     _sb_.append(this.time_point_cfgid);
/*  448 */     _sb_.append(",");
/*  449 */     _sb_.append(this.corps);
/*  450 */     _sb_.append(",");
/*  451 */     _sb_.append(this.next_mailed);
/*  452 */     _sb_.append(",");
/*  453 */     _sb_.append(this.backup_zones);
/*  454 */     _sb_.append(")");
/*  455 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  461 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  462 */     lb.add(new xdb.logs.ListenableChanged().setVarName("time_point_cfgid"));
/*  463 */     lb.add(new xdb.logs.ListenableMap().setVarName("corps"));
/*  464 */     lb.add(new xdb.logs.ListenableMap().setVarName("next_mailed"));
/*  465 */     lb.add(new xdb.logs.ListenableChanged().setVarName("backup_zones"));
/*  466 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CrossbattlePointRaceInfo {
/*      */     private Const() {}
/*      */     
/*      */     CrossbattlePointRaceInfo nThis() {
/*  473 */       return CrossbattlePointRaceInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  479 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossbattlePointRaceInfo copy()
/*      */     {
/*  485 */       return CrossbattlePointRaceInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossbattlePointRaceInfo toData()
/*      */     {
/*  491 */       return CrossbattlePointRaceInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CrossbattlePointRaceInfo toBean()
/*      */     {
/*  496 */       return CrossbattlePointRaceInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossbattlePointRaceInfo toDataIf()
/*      */     {
/*  502 */       return CrossbattlePointRaceInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CrossbattlePointRaceInfo toBeanIf()
/*      */     {
/*  507 */       return CrossbattlePointRaceInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTime_point_cfgid()
/*      */     {
/*  514 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*  515 */       return CrossbattlePointRaceInfo.this.time_point_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.PointRaceInfo> getCorps()
/*      */     {
/*  522 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*  523 */       return xdb.Consts.constMap(CrossbattlePointRaceInfo.this.corps);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.PointRaceInfo> getCorpsAsData()
/*      */     {
/*  530 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*      */       
/*  532 */       CrossbattlePointRaceInfo _o_ = CrossbattlePointRaceInfo.this;
/*  533 */       Map<Long, xbean.PointRaceInfo> corps = new HashMap();
/*  534 */       for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : _o_.corps.entrySet())
/*  535 */         corps.put(_e_.getKey(), new PointRaceInfo.Data((xbean.PointRaceInfo)_e_.getValue()));
/*  536 */       return corps;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Boolean> getNext_mailed()
/*      */     {
/*  543 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*  544 */       return xdb.Consts.constMap(CrossbattlePointRaceInfo.this.next_mailed);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Boolean> getNext_mailedAsData()
/*      */     {
/*  551 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*      */       
/*  553 */       CrossbattlePointRaceInfo _o_ = CrossbattlePointRaceInfo.this;
/*  554 */       Map<Long, Boolean> next_mailed = new HashMap();
/*  555 */       for (Map.Entry<Long, Boolean> _e_ : _o_.next_mailed.entrySet())
/*  556 */         next_mailed.put(_e_.getKey(), _e_.getValue());
/*  557 */       return next_mailed;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getBackup_zones()
/*      */     {
/*  564 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*  565 */       return xdb.Consts.constList(CrossbattlePointRaceInfo.this.backup_zones);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getBackup_zonesAsData()
/*      */     {
/*  571 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*      */       
/*  573 */       CrossbattlePointRaceInfo _o_ = CrossbattlePointRaceInfo.this;
/*  574 */       List<Integer> backup_zones = new ArrayList();
/*  575 */       backup_zones.addAll(_o_.backup_zones);
/*  576 */       return backup_zones;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTime_point_cfgid(int _v_)
/*      */     {
/*  583 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*  584 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  590 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*  591 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  597 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*  598 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  604 */       return CrossbattlePointRaceInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  610 */       return CrossbattlePointRaceInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  616 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*  617 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  623 */       return CrossbattlePointRaceInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  629 */       return CrossbattlePointRaceInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  635 */       CrossbattlePointRaceInfo.this._xdb_verify_unsafe_();
/*  636 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  642 */       return CrossbattlePointRaceInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  648 */       return CrossbattlePointRaceInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  654 */       return CrossbattlePointRaceInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  660 */       return CrossbattlePointRaceInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  666 */       return CrossbattlePointRaceInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  672 */       return CrossbattlePointRaceInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  678 */       return CrossbattlePointRaceInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CrossbattlePointRaceInfo
/*      */   {
/*      */     private int time_point_cfgid;
/*      */     
/*      */     private HashMap<Long, xbean.PointRaceInfo> corps;
/*      */     
/*      */     private HashMap<Long, Boolean> next_mailed;
/*      */     
/*      */     private ArrayList<Integer> backup_zones;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  696 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  701 */       this.corps = new HashMap();
/*  702 */       this.next_mailed = new HashMap();
/*  703 */       this.backup_zones = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.CrossbattlePointRaceInfo _o1_)
/*      */     {
/*  708 */       if ((_o1_ instanceof CrossbattlePointRaceInfo)) { assign((CrossbattlePointRaceInfo)_o1_);
/*  709 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  710 */       } else if ((_o1_ instanceof CrossbattlePointRaceInfo.Const)) assign(((CrossbattlePointRaceInfo.Const)_o1_).nThis()); else {
/*  711 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CrossbattlePointRaceInfo _o_) {
/*  716 */       this.time_point_cfgid = _o_.time_point_cfgid;
/*  717 */       this.corps = new HashMap();
/*  718 */       for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : _o_.corps.entrySet())
/*  719 */         this.corps.put(_e_.getKey(), new PointRaceInfo.Data((xbean.PointRaceInfo)_e_.getValue()));
/*  720 */       this.next_mailed = new HashMap();
/*  721 */       for (Map.Entry<Long, Boolean> _e_ : _o_.next_mailed.entrySet())
/*  722 */         this.next_mailed.put(_e_.getKey(), _e_.getValue());
/*  723 */       this.backup_zones = new ArrayList();
/*  724 */       this.backup_zones.addAll(_o_.backup_zones);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  729 */       this.time_point_cfgid = _o_.time_point_cfgid;
/*  730 */       this.corps = new HashMap();
/*  731 */       for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : _o_.corps.entrySet())
/*  732 */         this.corps.put(_e_.getKey(), new PointRaceInfo.Data((xbean.PointRaceInfo)_e_.getValue()));
/*  733 */       this.next_mailed = new HashMap();
/*  734 */       for (Map.Entry<Long, Boolean> _e_ : _o_.next_mailed.entrySet())
/*  735 */         this.next_mailed.put(_e_.getKey(), _e_.getValue());
/*  736 */       this.backup_zones = new ArrayList();
/*  737 */       this.backup_zones.addAll(_o_.backup_zones);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  743 */       _os_.marshal(this.time_point_cfgid);
/*  744 */       _os_.compact_uint32(this.corps.size());
/*  745 */       for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : this.corps.entrySet())
/*      */       {
/*  747 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  748 */         ((xbean.PointRaceInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  750 */       _os_.compact_uint32(this.next_mailed.size());
/*  751 */       for (Map.Entry<Long, Boolean> _e_ : this.next_mailed.entrySet())
/*      */       {
/*  753 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  754 */         _os_.marshal(((Boolean)_e_.getValue()).booleanValue());
/*      */       }
/*  756 */       _os_.compact_uint32(this.backup_zones.size());
/*  757 */       for (Integer _v_ : this.backup_zones)
/*      */       {
/*  759 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  761 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  767 */       this.time_point_cfgid = _os_.unmarshal_int();
/*      */       
/*  769 */       int size = _os_.uncompact_uint32();
/*  770 */       if (size >= 12)
/*      */       {
/*  772 */         this.corps = new HashMap(size * 2);
/*      */       }
/*  774 */       for (; size > 0; size--)
/*      */       {
/*  776 */         long _k_ = 0L;
/*  777 */         _k_ = _os_.unmarshal_long();
/*  778 */         xbean.PointRaceInfo _v_ = xbean.Pod.newPointRaceInfoData();
/*  779 */         _v_.unmarshal(_os_);
/*  780 */         this.corps.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  784 */       int size = _os_.uncompact_uint32();
/*  785 */       if (size >= 12)
/*      */       {
/*  787 */         this.next_mailed = new HashMap(size * 2);
/*      */       }
/*  789 */       for (; size > 0; size--)
/*      */       {
/*  791 */         long _k_ = 0L;
/*  792 */         _k_ = _os_.unmarshal_long();
/*  793 */         boolean _v_ = false;
/*  794 */         _v_ = _os_.unmarshal_boolean();
/*  795 */         this.next_mailed.put(Long.valueOf(_k_), Boolean.valueOf(_v_));
/*      */       }
/*      */       
/*  798 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  800 */         int _v_ = 0;
/*  801 */         _v_ = _os_.unmarshal_int();
/*  802 */         this.backup_zones.add(Integer.valueOf(_v_));
/*      */       }
/*  804 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  810 */       int _size_ = 0;
/*  811 */       _size_ += CodedOutputStream.computeInt32Size(1, this.time_point_cfgid);
/*  812 */       for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : this.corps.entrySet())
/*      */       {
/*  814 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  815 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  817 */       for (Map.Entry<Long, Boolean> _e_ : this.next_mailed.entrySet())
/*      */       {
/*  819 */         _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  820 */         _size_ += CodedOutputStream.computeBoolSize(5, ((Boolean)_e_.getValue()).booleanValue());
/*      */       }
/*  822 */       for (Integer _v_ : this.backup_zones)
/*      */       {
/*  824 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/*  826 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  834 */         _output_.writeInt32(1, this.time_point_cfgid);
/*  835 */         for (Map.Entry<Long, xbean.PointRaceInfo> _e_ : this.corps.entrySet())
/*      */         {
/*  837 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  838 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */         }
/*  840 */         for (Map.Entry<Long, Boolean> _e_ : this.next_mailed.entrySet())
/*      */         {
/*  842 */           _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  843 */           _output_.writeBool(5, ((Boolean)_e_.getValue()).booleanValue());
/*      */         }
/*  845 */         for (Integer _v_ : this.backup_zones)
/*      */         {
/*  847 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  852 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  854 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  862 */         boolean done = false;
/*  863 */         while (!done)
/*      */         {
/*  865 */           int tag = _input_.readTag();
/*  866 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  870 */             done = true;
/*  871 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  875 */             this.time_point_cfgid = _input_.readInt32();
/*  876 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  880 */             long _k_ = 0L;
/*  881 */             _k_ = _input_.readInt64();
/*  882 */             int readTag = _input_.readTag();
/*  883 */             if (18 != readTag)
/*      */             {
/*  885 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  887 */             xbean.PointRaceInfo _v_ = xbean.Pod.newPointRaceInfoData();
/*  888 */             _input_.readMessage(_v_);
/*  889 */             this.corps.put(Long.valueOf(_k_), _v_);
/*  890 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  894 */             long _k_ = 0L;
/*  895 */             _k_ = _input_.readInt64();
/*  896 */             int readTag = _input_.readTag();
/*  897 */             if (40 != readTag)
/*      */             {
/*  899 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  901 */             boolean _v_ = false;
/*  902 */             _v_ = _input_.readBool();
/*  903 */             this.next_mailed.put(Long.valueOf(_k_), Boolean.valueOf(_v_));
/*  904 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  908 */             int _v_ = 0;
/*  909 */             _v_ = _input_.readInt32();
/*  910 */             this.backup_zones.add(Integer.valueOf(_v_));
/*  911 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  915 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  917 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  926 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  930 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  932 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossbattlePointRaceInfo copy()
/*      */     {
/*  938 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossbattlePointRaceInfo toData()
/*      */     {
/*  944 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CrossbattlePointRaceInfo toBean()
/*      */     {
/*  949 */       return new CrossbattlePointRaceInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossbattlePointRaceInfo toDataIf()
/*      */     {
/*  955 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CrossbattlePointRaceInfo toBeanIf()
/*      */     {
/*  960 */       return new CrossbattlePointRaceInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  966 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  970 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  974 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  978 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  982 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  986 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  990 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTime_point_cfgid()
/*      */     {
/*  997 */       return this.time_point_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.PointRaceInfo> getCorps()
/*      */     {
/* 1004 */       return this.corps;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.PointRaceInfo> getCorpsAsData()
/*      */     {
/* 1011 */       return this.corps;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Boolean> getNext_mailed()
/*      */     {
/* 1018 */       return this.next_mailed;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Boolean> getNext_mailedAsData()
/*      */     {
/* 1025 */       return this.next_mailed;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getBackup_zones()
/*      */     {
/* 1032 */       return this.backup_zones;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getBackup_zonesAsData()
/*      */     {
/* 1039 */       return this.backup_zones;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTime_point_cfgid(int _v_)
/*      */     {
/* 1046 */       this.time_point_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1052 */       if (!(_o1_ instanceof Data)) return false;
/* 1053 */       Data _o_ = (Data)_o1_;
/* 1054 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/* 1055 */       if (!this.corps.equals(_o_.corps)) return false;
/* 1056 */       if (!this.next_mailed.equals(_o_.next_mailed)) return false;
/* 1057 */       if (!this.backup_zones.equals(_o_.backup_zones)) return false;
/* 1058 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1064 */       int _h_ = 0;
/* 1065 */       _h_ += this.time_point_cfgid;
/* 1066 */       _h_ += this.corps.hashCode();
/* 1067 */       _h_ += this.next_mailed.hashCode();
/* 1068 */       _h_ += this.backup_zones.hashCode();
/* 1069 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1075 */       StringBuilder _sb_ = new StringBuilder();
/* 1076 */       _sb_.append("(");
/* 1077 */       _sb_.append(this.time_point_cfgid);
/* 1078 */       _sb_.append(",");
/* 1079 */       _sb_.append(this.corps);
/* 1080 */       _sb_.append(",");
/* 1081 */       _sb_.append(this.next_mailed);
/* 1082 */       _sb_.append(",");
/* 1083 */       _sb_.append(this.backup_zones);
/* 1084 */       _sb_.append(")");
/* 1085 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossbattlePointRaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */