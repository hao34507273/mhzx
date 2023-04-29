/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ 
/*      */ public final class AllWingPlans extends XBean implements xbean.AllWingPlans
/*      */ {
/*      */   private HashMap<Integer, xbean.WingPlan> wings;
/*      */   private int curplan;
/*      */   private HashMap<Integer, xbean.TransferOccupationWing> transfer_occupation_wing_map;
/*      */   private int effectwingoccid;
/*      */   private HashMap<Integer, Integer> occ2lastplanoccid;
/*      */   private LinkedList<Integer> newoccplans;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.wings.clear();
/*   29 */     this.curplan = 0;
/*   30 */     this.transfer_occupation_wing_map.clear();
/*   31 */     this.effectwingoccid = 0;
/*   32 */     this.occ2lastplanoccid.clear();
/*   33 */     this.newoccplans.clear();
/*      */   }
/*      */   
/*      */   AllWingPlans(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.wings = new HashMap();
/*   40 */     this.transfer_occupation_wing_map = new HashMap();
/*   41 */     this.occ2lastplanoccid = new HashMap();
/*   42 */     this.newoccplans = new LinkedList();
/*      */   }
/*      */   
/*      */   public AllWingPlans()
/*      */   {
/*   47 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AllWingPlans(AllWingPlans _o_)
/*      */   {
/*   52 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AllWingPlans(xbean.AllWingPlans _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   57 */     super(_xp_, _vn_);
/*   58 */     if ((_o1_ instanceof AllWingPlans)) { assign((AllWingPlans)_o1_);
/*   59 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   60 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   61 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AllWingPlans _o_) {
/*   66 */     _o_._xdb_verify_unsafe_();
/*   67 */     this.wings = new HashMap();
/*   68 */     for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/*   69 */       this.wings.put(_e_.getKey(), new WingPlan((xbean.WingPlan)_e_.getValue(), this, "wings"));
/*   70 */     this.curplan = _o_.curplan;
/*   71 */     this.transfer_occupation_wing_map = new HashMap();
/*   72 */     for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : _o_.transfer_occupation_wing_map.entrySet())
/*   73 */       this.transfer_occupation_wing_map.put(_e_.getKey(), new TransferOccupationWing((xbean.TransferOccupationWing)_e_.getValue(), this, "transfer_occupation_wing_map"));
/*   74 */     this.effectwingoccid = _o_.effectwingoccid;
/*   75 */     this.occ2lastplanoccid = new HashMap();
/*   76 */     for (Map.Entry<Integer, Integer> _e_ : _o_.occ2lastplanoccid.entrySet())
/*   77 */       this.occ2lastplanoccid.put(_e_.getKey(), _e_.getValue());
/*   78 */     this.newoccplans = new LinkedList();
/*   79 */     this.newoccplans.addAll(_o_.newoccplans);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   84 */     this.wings = new HashMap();
/*   85 */     for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/*   86 */       this.wings.put(_e_.getKey(), new WingPlan((xbean.WingPlan)_e_.getValue(), this, "wings"));
/*   87 */     this.curplan = _o_.curplan;
/*   88 */     this.transfer_occupation_wing_map = new HashMap();
/*   89 */     for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : _o_.transfer_occupation_wing_map.entrySet())
/*   90 */       this.transfer_occupation_wing_map.put(_e_.getKey(), new TransferOccupationWing((xbean.TransferOccupationWing)_e_.getValue(), this, "transfer_occupation_wing_map"));
/*   91 */     this.effectwingoccid = _o_.effectwingoccid;
/*   92 */     this.occ2lastplanoccid = new HashMap();
/*   93 */     for (Map.Entry<Integer, Integer> _e_ : _o_.occ2lastplanoccid.entrySet())
/*   94 */       this.occ2lastplanoccid.put(_e_.getKey(), _e_.getValue());
/*   95 */     this.newoccplans = new LinkedList();
/*   96 */     this.newoccplans.addAll(_o_.newoccplans);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  102 */     _xdb_verify_unsafe_();
/*  103 */     _os_.compact_uint32(this.wings.size());
/*  104 */     for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*      */     {
/*  106 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  107 */       ((xbean.WingPlan)_e_.getValue()).marshal(_os_);
/*      */     }
/*  109 */     _os_.marshal(this.curplan);
/*  110 */     _os_.compact_uint32(this.transfer_occupation_wing_map.size());
/*  111 */     for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : this.transfer_occupation_wing_map.entrySet())
/*      */     {
/*  113 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  114 */       ((xbean.TransferOccupationWing)_e_.getValue()).marshal(_os_);
/*      */     }
/*  116 */     _os_.marshal(this.effectwingoccid);
/*  117 */     _os_.compact_uint32(this.occ2lastplanoccid.size());
/*  118 */     for (Map.Entry<Integer, Integer> _e_ : this.occ2lastplanoccid.entrySet())
/*      */     {
/*  120 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  121 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  123 */     _os_.compact_uint32(this.newoccplans.size());
/*  124 */     for (Integer _v_ : this.newoccplans)
/*      */     {
/*  126 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  128 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  134 */     _xdb_verify_unsafe_();
/*      */     
/*  136 */     int size = _os_.uncompact_uint32();
/*  137 */     if (size >= 12)
/*      */     {
/*  139 */       this.wings = new HashMap(size * 2);
/*      */     }
/*  141 */     for (; size > 0; size--)
/*      */     {
/*  143 */       int _k_ = 0;
/*  144 */       _k_ = _os_.unmarshal_int();
/*  145 */       xbean.WingPlan _v_ = new WingPlan(0, this, "wings");
/*  146 */       _v_.unmarshal(_os_);
/*  147 */       this.wings.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  150 */     this.curplan = _os_.unmarshal_int();
/*      */     
/*  152 */     int size = _os_.uncompact_uint32();
/*  153 */     if (size >= 12)
/*      */     {
/*  155 */       this.transfer_occupation_wing_map = new HashMap(size * 2);
/*      */     }
/*  157 */     for (; size > 0; size--)
/*      */     {
/*  159 */       int _k_ = 0;
/*  160 */       _k_ = _os_.unmarshal_int();
/*  161 */       xbean.TransferOccupationWing _v_ = new TransferOccupationWing(0, this, "transfer_occupation_wing_map");
/*  162 */       _v_.unmarshal(_os_);
/*  163 */       this.transfer_occupation_wing_map.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  166 */     this.effectwingoccid = _os_.unmarshal_int();
/*      */     
/*  168 */     int size = _os_.uncompact_uint32();
/*  169 */     if (size >= 12)
/*      */     {
/*  171 */       this.occ2lastplanoccid = new HashMap(size * 2);
/*      */     }
/*  173 */     for (; size > 0; size--)
/*      */     {
/*  175 */       int _k_ = 0;
/*  176 */       _k_ = _os_.unmarshal_int();
/*  177 */       int _v_ = 0;
/*  178 */       _v_ = _os_.unmarshal_int();
/*  179 */       this.occ2lastplanoccid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  182 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  184 */       int _v_ = 0;
/*  185 */       _v_ = _os_.unmarshal_int();
/*  186 */       this.newoccplans.add(Integer.valueOf(_v_));
/*      */     }
/*  188 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  194 */     _xdb_verify_unsafe_();
/*  195 */     int _size_ = 0;
/*  196 */     for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*      */     {
/*  198 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  199 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */     }
/*  201 */     _size_ += CodedOutputStream.computeInt32Size(2, this.curplan);
/*  202 */     for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : this.transfer_occupation_wing_map.entrySet())
/*      */     {
/*  204 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  205 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */     }
/*  207 */     _size_ += CodedOutputStream.computeInt32Size(4, this.effectwingoccid);
/*  208 */     for (Map.Entry<Integer, Integer> _e_ : this.occ2lastplanoccid.entrySet())
/*      */     {
/*  210 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  211 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  213 */     for (Integer _v_ : this.newoccplans)
/*      */     {
/*  215 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  217 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  223 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  226 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*      */       {
/*  228 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  229 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  231 */       _output_.writeInt32(2, this.curplan);
/*  232 */       for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : this.transfer_occupation_wing_map.entrySet())
/*      */       {
/*  234 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  235 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  237 */       _output_.writeInt32(4, this.effectwingoccid);
/*  238 */       for (Map.Entry<Integer, Integer> _e_ : this.occ2lastplanoccid.entrySet())
/*      */       {
/*  240 */         _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  241 */         _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  243 */       for (Integer _v_ : this.newoccplans)
/*      */       {
/*  245 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  250 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  252 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  258 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  261 */       boolean done = false;
/*  262 */       while (!done)
/*      */       {
/*  264 */         int tag = _input_.readTag();
/*  265 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  269 */           done = true;
/*  270 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  274 */           int _k_ = 0;
/*  275 */           _k_ = _input_.readInt32();
/*  276 */           int readTag = _input_.readTag();
/*  277 */           if (10 != readTag)
/*      */           {
/*  279 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  281 */           xbean.WingPlan _v_ = new WingPlan(0, this, "wings");
/*  282 */           _input_.readMessage(_v_);
/*  283 */           this.wings.put(Integer.valueOf(_k_), _v_);
/*  284 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  288 */           this.curplan = _input_.readInt32();
/*  289 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  293 */           int _k_ = 0;
/*  294 */           _k_ = _input_.readInt32();
/*  295 */           int readTag = _input_.readTag();
/*  296 */           if (26 != readTag)
/*      */           {
/*  298 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  300 */           xbean.TransferOccupationWing _v_ = new TransferOccupationWing(0, this, "transfer_occupation_wing_map");
/*  301 */           _input_.readMessage(_v_);
/*  302 */           this.transfer_occupation_wing_map.put(Integer.valueOf(_k_), _v_);
/*  303 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  307 */           this.effectwingoccid = _input_.readInt32();
/*  308 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  312 */           int _k_ = 0;
/*  313 */           _k_ = _input_.readInt32();
/*  314 */           int readTag = _input_.readTag();
/*  315 */           if (40 != readTag)
/*      */           {
/*  317 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  319 */           int _v_ = 0;
/*  320 */           _v_ = _input_.readInt32();
/*  321 */           this.occ2lastplanoccid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  322 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  326 */           int _v_ = 0;
/*  327 */           _v_ = _input_.readInt32();
/*  328 */           this.newoccplans.add(Integer.valueOf(_v_));
/*  329 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  333 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  335 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  344 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  348 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  350 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AllWingPlans copy()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     return new AllWingPlans(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AllWingPlans toData()
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AllWingPlans toBean()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return new AllWingPlans(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AllWingPlans toDataIf()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AllWingPlans toBeanIf()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.WingPlan> getWings()
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     return xdb.Logs.logMap(new LogKey(this, "wings"), this.wings);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.WingPlan> getWingsAsData()
/*      */   {
/*  405 */     _xdb_verify_unsafe_();
/*      */     
/*  407 */     AllWingPlans _o_ = this;
/*  408 */     Map<Integer, xbean.WingPlan> wings = new HashMap();
/*  409 */     for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/*  410 */       wings.put(_e_.getKey(), new WingPlan.Data((xbean.WingPlan)_e_.getValue()));
/*  411 */     return wings;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurplan()
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     return this.curplan;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TransferOccupationWing> getTransfer_occupation_wing_map()
/*      */   {
/*  426 */     _xdb_verify_unsafe_();
/*  427 */     return xdb.Logs.logMap(new LogKey(this, "transfer_occupation_wing_map"), this.transfer_occupation_wing_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TransferOccupationWing> getTransfer_occupation_wing_mapAsData()
/*      */   {
/*  434 */     _xdb_verify_unsafe_();
/*      */     
/*  436 */     AllWingPlans _o_ = this;
/*  437 */     Map<Integer, xbean.TransferOccupationWing> transfer_occupation_wing_map = new HashMap();
/*  438 */     for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : _o_.transfer_occupation_wing_map.entrySet())
/*  439 */       transfer_occupation_wing_map.put(_e_.getKey(), new TransferOccupationWing.Data((xbean.TransferOccupationWing)_e_.getValue()));
/*  440 */     return transfer_occupation_wing_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getEffectwingoccid()
/*      */   {
/*  447 */     _xdb_verify_unsafe_();
/*  448 */     return this.effectwingoccid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getOcc2lastplanoccid()
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*  456 */     return xdb.Logs.logMap(new LogKey(this, "occ2lastplanoccid"), this.occ2lastplanoccid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getOcc2lastplanoccidAsData()
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*      */     
/*  465 */     AllWingPlans _o_ = this;
/*  466 */     Map<Integer, Integer> occ2lastplanoccid = new HashMap();
/*  467 */     for (Map.Entry<Integer, Integer> _e_ : _o_.occ2lastplanoccid.entrySet())
/*  468 */       occ2lastplanoccid.put(_e_.getKey(), _e_.getValue());
/*  469 */     return occ2lastplanoccid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getNewoccplans()
/*      */   {
/*  476 */     _xdb_verify_unsafe_();
/*  477 */     return xdb.Logs.logList(new LogKey(this, "newoccplans"), this.newoccplans);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getNewoccplansAsData()
/*      */   {
/*  483 */     _xdb_verify_unsafe_();
/*      */     
/*  485 */     AllWingPlans _o_ = this;
/*  486 */     List<Integer> newoccplans = new LinkedList();
/*  487 */     newoccplans.addAll(_o_.newoccplans);
/*  488 */     return newoccplans;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurplan(int _v_)
/*      */   {
/*  495 */     _xdb_verify_unsafe_();
/*  496 */     xdb.Logs.logIf(new LogKey(this, "curplan")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  500 */         new xdb.logs.LogInt(this, AllWingPlans.this.curplan)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  504 */             AllWingPlans.this.curplan = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  508 */     });
/*  509 */     this.curplan = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEffectwingoccid(int _v_)
/*      */   {
/*  516 */     _xdb_verify_unsafe_();
/*  517 */     xdb.Logs.logIf(new LogKey(this, "effectwingoccid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  521 */         new xdb.logs.LogInt(this, AllWingPlans.this.effectwingoccid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  525 */             AllWingPlans.this.effectwingoccid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  529 */     });
/*  530 */     this.effectwingoccid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  536 */     _xdb_verify_unsafe_();
/*  537 */     AllWingPlans _o_ = null;
/*  538 */     if ((_o1_ instanceof AllWingPlans)) { _o_ = (AllWingPlans)_o1_;
/*  539 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  540 */       return false;
/*  541 */     if (!this.wings.equals(_o_.wings)) return false;
/*  542 */     if (this.curplan != _o_.curplan) return false;
/*  543 */     if (!this.transfer_occupation_wing_map.equals(_o_.transfer_occupation_wing_map)) return false;
/*  544 */     if (this.effectwingoccid != _o_.effectwingoccid) return false;
/*  545 */     if (!this.occ2lastplanoccid.equals(_o_.occ2lastplanoccid)) return false;
/*  546 */     if (!this.newoccplans.equals(_o_.newoccplans)) return false;
/*  547 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  553 */     _xdb_verify_unsafe_();
/*  554 */     int _h_ = 0;
/*  555 */     _h_ += this.wings.hashCode();
/*  556 */     _h_ += this.curplan;
/*  557 */     _h_ += this.transfer_occupation_wing_map.hashCode();
/*  558 */     _h_ += this.effectwingoccid;
/*  559 */     _h_ += this.occ2lastplanoccid.hashCode();
/*  560 */     _h_ += this.newoccplans.hashCode();
/*  561 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  567 */     _xdb_verify_unsafe_();
/*  568 */     StringBuilder _sb_ = new StringBuilder();
/*  569 */     _sb_.append("(");
/*  570 */     _sb_.append(this.wings);
/*  571 */     _sb_.append(",");
/*  572 */     _sb_.append(this.curplan);
/*  573 */     _sb_.append(",");
/*  574 */     _sb_.append(this.transfer_occupation_wing_map);
/*  575 */     _sb_.append(",");
/*  576 */     _sb_.append(this.effectwingoccid);
/*  577 */     _sb_.append(",");
/*  578 */     _sb_.append(this.occ2lastplanoccid);
/*  579 */     _sb_.append(",");
/*  580 */     _sb_.append(this.newoccplans);
/*  581 */     _sb_.append(")");
/*  582 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  588 */     ListenableBean lb = new ListenableBean();
/*  589 */     lb.add(new xdb.logs.ListenableMap().setVarName("wings"));
/*  590 */     lb.add(new xdb.logs.ListenableChanged().setVarName("curplan"));
/*  591 */     lb.add(new xdb.logs.ListenableMap().setVarName("transfer_occupation_wing_map"));
/*  592 */     lb.add(new xdb.logs.ListenableChanged().setVarName("effectwingoccid"));
/*  593 */     lb.add(new xdb.logs.ListenableMap().setVarName("occ2lastplanoccid"));
/*  594 */     lb.add(new xdb.logs.ListenableChanged().setVarName("newoccplans"));
/*  595 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AllWingPlans {
/*      */     private Const() {}
/*      */     
/*      */     AllWingPlans nThis() {
/*  602 */       return AllWingPlans.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  608 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllWingPlans copy()
/*      */     {
/*  614 */       return AllWingPlans.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllWingPlans toData()
/*      */     {
/*  620 */       return AllWingPlans.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AllWingPlans toBean()
/*      */     {
/*  625 */       return AllWingPlans.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllWingPlans toDataIf()
/*      */     {
/*  631 */       return AllWingPlans.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AllWingPlans toBeanIf()
/*      */     {
/*  636 */       return AllWingPlans.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.WingPlan> getWings()
/*      */     {
/*  643 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  644 */       return xdb.Consts.constMap(AllWingPlans.this.wings);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.WingPlan> getWingsAsData()
/*      */     {
/*  651 */       AllWingPlans.this._xdb_verify_unsafe_();
/*      */       
/*  653 */       AllWingPlans _o_ = AllWingPlans.this;
/*  654 */       Map<Integer, xbean.WingPlan> wings = new HashMap();
/*  655 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/*  656 */         wings.put(_e_.getKey(), new WingPlan.Data((xbean.WingPlan)_e_.getValue()));
/*  657 */       return wings;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurplan()
/*      */     {
/*  664 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  665 */       return AllWingPlans.this.curplan;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationWing> getTransfer_occupation_wing_map()
/*      */     {
/*  672 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  673 */       return xdb.Consts.constMap(AllWingPlans.this.transfer_occupation_wing_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationWing> getTransfer_occupation_wing_mapAsData()
/*      */     {
/*  680 */       AllWingPlans.this._xdb_verify_unsafe_();
/*      */       
/*  682 */       AllWingPlans _o_ = AllWingPlans.this;
/*  683 */       Map<Integer, xbean.TransferOccupationWing> transfer_occupation_wing_map = new HashMap();
/*  684 */       for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : _o_.transfer_occupation_wing_map.entrySet())
/*  685 */         transfer_occupation_wing_map.put(_e_.getKey(), new TransferOccupationWing.Data((xbean.TransferOccupationWing)_e_.getValue()));
/*  686 */       return transfer_occupation_wing_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEffectwingoccid()
/*      */     {
/*  693 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  694 */       return AllWingPlans.this.effectwingoccid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOcc2lastplanoccid()
/*      */     {
/*  701 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  702 */       return xdb.Consts.constMap(AllWingPlans.this.occ2lastplanoccid);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOcc2lastplanoccidAsData()
/*      */     {
/*  709 */       AllWingPlans.this._xdb_verify_unsafe_();
/*      */       
/*  711 */       AllWingPlans _o_ = AllWingPlans.this;
/*  712 */       Map<Integer, Integer> occ2lastplanoccid = new HashMap();
/*  713 */       for (Map.Entry<Integer, Integer> _e_ : _o_.occ2lastplanoccid.entrySet())
/*  714 */         occ2lastplanoccid.put(_e_.getKey(), _e_.getValue());
/*  715 */       return occ2lastplanoccid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getNewoccplans()
/*      */     {
/*  722 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  723 */       return xdb.Consts.constList(AllWingPlans.this.newoccplans);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getNewoccplansAsData()
/*      */     {
/*  729 */       AllWingPlans.this._xdb_verify_unsafe_();
/*      */       
/*  731 */       AllWingPlans _o_ = AllWingPlans.this;
/*  732 */       List<Integer> newoccplans = new LinkedList();
/*  733 */       newoccplans.addAll(_o_.newoccplans);
/*  734 */       return newoccplans;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurplan(int _v_)
/*      */     {
/*  741 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  742 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEffectwingoccid(int _v_)
/*      */     {
/*  749 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  750 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  756 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  757 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  763 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  764 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  770 */       return AllWingPlans.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  776 */       return AllWingPlans.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  782 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  783 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  789 */       return AllWingPlans.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  795 */       return AllWingPlans.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  801 */       AllWingPlans.this._xdb_verify_unsafe_();
/*  802 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  808 */       return AllWingPlans.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  814 */       return AllWingPlans.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  820 */       return AllWingPlans.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  826 */       return AllWingPlans.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  832 */       return AllWingPlans.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  838 */       return AllWingPlans.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  844 */       return AllWingPlans.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AllWingPlans
/*      */   {
/*      */     private HashMap<Integer, xbean.WingPlan> wings;
/*      */     
/*      */     private int curplan;
/*      */     
/*      */     private HashMap<Integer, xbean.TransferOccupationWing> transfer_occupation_wing_map;
/*      */     
/*      */     private int effectwingoccid;
/*      */     
/*      */     private HashMap<Integer, Integer> occ2lastplanoccid;
/*      */     
/*      */     private LinkedList<Integer> newoccplans;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  866 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  871 */       this.wings = new HashMap();
/*  872 */       this.transfer_occupation_wing_map = new HashMap();
/*  873 */       this.occ2lastplanoccid = new HashMap();
/*  874 */       this.newoccplans = new LinkedList();
/*      */     }
/*      */     
/*      */     Data(xbean.AllWingPlans _o1_)
/*      */     {
/*  879 */       if ((_o1_ instanceof AllWingPlans)) { assign((AllWingPlans)_o1_);
/*  880 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  881 */       } else if ((_o1_ instanceof AllWingPlans.Const)) assign(((AllWingPlans.Const)_o1_).nThis()); else {
/*  882 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AllWingPlans _o_) {
/*  887 */       this.wings = new HashMap();
/*  888 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/*  889 */         this.wings.put(_e_.getKey(), new WingPlan.Data((xbean.WingPlan)_e_.getValue()));
/*  890 */       this.curplan = _o_.curplan;
/*  891 */       this.transfer_occupation_wing_map = new HashMap();
/*  892 */       for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : _o_.transfer_occupation_wing_map.entrySet())
/*  893 */         this.transfer_occupation_wing_map.put(_e_.getKey(), new TransferOccupationWing.Data((xbean.TransferOccupationWing)_e_.getValue()));
/*  894 */       this.effectwingoccid = _o_.effectwingoccid;
/*  895 */       this.occ2lastplanoccid = new HashMap();
/*  896 */       for (Map.Entry<Integer, Integer> _e_ : _o_.occ2lastplanoccid.entrySet())
/*  897 */         this.occ2lastplanoccid.put(_e_.getKey(), _e_.getValue());
/*  898 */       this.newoccplans = new LinkedList();
/*  899 */       this.newoccplans.addAll(_o_.newoccplans);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  904 */       this.wings = new HashMap();
/*  905 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/*  906 */         this.wings.put(_e_.getKey(), new WingPlan.Data((xbean.WingPlan)_e_.getValue()));
/*  907 */       this.curplan = _o_.curplan;
/*  908 */       this.transfer_occupation_wing_map = new HashMap();
/*  909 */       for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : _o_.transfer_occupation_wing_map.entrySet())
/*  910 */         this.transfer_occupation_wing_map.put(_e_.getKey(), new TransferOccupationWing.Data((xbean.TransferOccupationWing)_e_.getValue()));
/*  911 */       this.effectwingoccid = _o_.effectwingoccid;
/*  912 */       this.occ2lastplanoccid = new HashMap();
/*  913 */       for (Map.Entry<Integer, Integer> _e_ : _o_.occ2lastplanoccid.entrySet())
/*  914 */         this.occ2lastplanoccid.put(_e_.getKey(), _e_.getValue());
/*  915 */       this.newoccplans = new LinkedList();
/*  916 */       this.newoccplans.addAll(_o_.newoccplans);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  922 */       _os_.compact_uint32(this.wings.size());
/*  923 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*      */       {
/*  925 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  926 */         ((xbean.WingPlan)_e_.getValue()).marshal(_os_);
/*      */       }
/*  928 */       _os_.marshal(this.curplan);
/*  929 */       _os_.compact_uint32(this.transfer_occupation_wing_map.size());
/*  930 */       for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : this.transfer_occupation_wing_map.entrySet())
/*      */       {
/*  932 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  933 */         ((xbean.TransferOccupationWing)_e_.getValue()).marshal(_os_);
/*      */       }
/*  935 */       _os_.marshal(this.effectwingoccid);
/*  936 */       _os_.compact_uint32(this.occ2lastplanoccid.size());
/*  937 */       for (Map.Entry<Integer, Integer> _e_ : this.occ2lastplanoccid.entrySet())
/*      */       {
/*  939 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  940 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  942 */       _os_.compact_uint32(this.newoccplans.size());
/*  943 */       for (Integer _v_ : this.newoccplans)
/*      */       {
/*  945 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  947 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  954 */       int size = _os_.uncompact_uint32();
/*  955 */       if (size >= 12)
/*      */       {
/*  957 */         this.wings = new HashMap(size * 2);
/*      */       }
/*  959 */       for (; size > 0; size--)
/*      */       {
/*  961 */         int _k_ = 0;
/*  962 */         _k_ = _os_.unmarshal_int();
/*  963 */         xbean.WingPlan _v_ = xbean.Pod.newWingPlanData();
/*  964 */         _v_.unmarshal(_os_);
/*  965 */         this.wings.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  968 */       this.curplan = _os_.unmarshal_int();
/*      */       
/*  970 */       int size = _os_.uncompact_uint32();
/*  971 */       if (size >= 12)
/*      */       {
/*  973 */         this.transfer_occupation_wing_map = new HashMap(size * 2);
/*      */       }
/*  975 */       for (; size > 0; size--)
/*      */       {
/*  977 */         int _k_ = 0;
/*  978 */         _k_ = _os_.unmarshal_int();
/*  979 */         xbean.TransferOccupationWing _v_ = xbean.Pod.newTransferOccupationWingData();
/*  980 */         _v_.unmarshal(_os_);
/*  981 */         this.transfer_occupation_wing_map.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  984 */       this.effectwingoccid = _os_.unmarshal_int();
/*      */       
/*  986 */       int size = _os_.uncompact_uint32();
/*  987 */       if (size >= 12)
/*      */       {
/*  989 */         this.occ2lastplanoccid = new HashMap(size * 2);
/*      */       }
/*  991 */       for (; size > 0; size--)
/*      */       {
/*  993 */         int _k_ = 0;
/*  994 */         _k_ = _os_.unmarshal_int();
/*  995 */         int _v_ = 0;
/*  996 */         _v_ = _os_.unmarshal_int();
/*  997 */         this.occ2lastplanoccid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1000 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1002 */         int _v_ = 0;
/* 1003 */         _v_ = _os_.unmarshal_int();
/* 1004 */         this.newoccplans.add(Integer.valueOf(_v_));
/*      */       }
/* 1006 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1012 */       int _size_ = 0;
/* 1013 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*      */       {
/* 1015 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 1016 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1018 */       _size_ += CodedOutputStream.computeInt32Size(2, this.curplan);
/* 1019 */       for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : this.transfer_occupation_wing_map.entrySet())
/*      */       {
/* 1021 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 1022 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1024 */       _size_ += CodedOutputStream.computeInt32Size(4, this.effectwingoccid);
/* 1025 */       for (Map.Entry<Integer, Integer> _e_ : this.occ2lastplanoccid.entrySet())
/*      */       {
/* 1027 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/* 1028 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1030 */       for (Integer _v_ : this.newoccplans)
/*      */       {
/* 1032 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/* 1034 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1042 */         for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*      */         {
/* 1044 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 1045 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1047 */         _output_.writeInt32(2, this.curplan);
/* 1048 */         for (Map.Entry<Integer, xbean.TransferOccupationWing> _e_ : this.transfer_occupation_wing_map.entrySet())
/*      */         {
/* 1050 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 1051 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1053 */         _output_.writeInt32(4, this.effectwingoccid);
/* 1054 */         for (Map.Entry<Integer, Integer> _e_ : this.occ2lastplanoccid.entrySet())
/*      */         {
/* 1056 */           _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/* 1057 */           _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1059 */         for (Integer _v_ : this.newoccplans)
/*      */         {
/* 1061 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1066 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1068 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1076 */         boolean done = false;
/* 1077 */         while (!done)
/*      */         {
/* 1079 */           int tag = _input_.readTag();
/* 1080 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1084 */             done = true;
/* 1085 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1089 */             int _k_ = 0;
/* 1090 */             _k_ = _input_.readInt32();
/* 1091 */             int readTag = _input_.readTag();
/* 1092 */             if (10 != readTag)
/*      */             {
/* 1094 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1096 */             xbean.WingPlan _v_ = xbean.Pod.newWingPlanData();
/* 1097 */             _input_.readMessage(_v_);
/* 1098 */             this.wings.put(Integer.valueOf(_k_), _v_);
/* 1099 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1103 */             this.curplan = _input_.readInt32();
/* 1104 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1108 */             int _k_ = 0;
/* 1109 */             _k_ = _input_.readInt32();
/* 1110 */             int readTag = _input_.readTag();
/* 1111 */             if (26 != readTag)
/*      */             {
/* 1113 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1115 */             xbean.TransferOccupationWing _v_ = xbean.Pod.newTransferOccupationWingData();
/* 1116 */             _input_.readMessage(_v_);
/* 1117 */             this.transfer_occupation_wing_map.put(Integer.valueOf(_k_), _v_);
/* 1118 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1122 */             this.effectwingoccid = _input_.readInt32();
/* 1123 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1127 */             int _k_ = 0;
/* 1128 */             _k_ = _input_.readInt32();
/* 1129 */             int readTag = _input_.readTag();
/* 1130 */             if (40 != readTag)
/*      */             {
/* 1132 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1134 */             int _v_ = 0;
/* 1135 */             _v_ = _input_.readInt32();
/* 1136 */             this.occ2lastplanoccid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1137 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1141 */             int _v_ = 0;
/* 1142 */             _v_ = _input_.readInt32();
/* 1143 */             this.newoccplans.add(Integer.valueOf(_v_));
/* 1144 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1148 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1150 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1159 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1163 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1165 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllWingPlans copy()
/*      */     {
/* 1171 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllWingPlans toData()
/*      */     {
/* 1177 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AllWingPlans toBean()
/*      */     {
/* 1182 */       return new AllWingPlans(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllWingPlans toDataIf()
/*      */     {
/* 1188 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AllWingPlans toBeanIf()
/*      */     {
/* 1193 */       return new AllWingPlans(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1199 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1203 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1207 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1211 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1215 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1219 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1223 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.WingPlan> getWings()
/*      */     {
/* 1230 */       return this.wings;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.WingPlan> getWingsAsData()
/*      */     {
/* 1237 */       return this.wings;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurplan()
/*      */     {
/* 1244 */       return this.curplan;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationWing> getTransfer_occupation_wing_map()
/*      */     {
/* 1251 */       return this.transfer_occupation_wing_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationWing> getTransfer_occupation_wing_mapAsData()
/*      */     {
/* 1258 */       return this.transfer_occupation_wing_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEffectwingoccid()
/*      */     {
/* 1265 */       return this.effectwingoccid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOcc2lastplanoccid()
/*      */     {
/* 1272 */       return this.occ2lastplanoccid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOcc2lastplanoccidAsData()
/*      */     {
/* 1279 */       return this.occ2lastplanoccid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getNewoccplans()
/*      */     {
/* 1286 */       return this.newoccplans;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getNewoccplansAsData()
/*      */     {
/* 1293 */       return this.newoccplans;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurplan(int _v_)
/*      */     {
/* 1300 */       this.curplan = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEffectwingoccid(int _v_)
/*      */     {
/* 1307 */       this.effectwingoccid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1313 */       if (!(_o1_ instanceof Data)) return false;
/* 1314 */       Data _o_ = (Data)_o1_;
/* 1315 */       if (!this.wings.equals(_o_.wings)) return false;
/* 1316 */       if (this.curplan != _o_.curplan) return false;
/* 1317 */       if (!this.transfer_occupation_wing_map.equals(_o_.transfer_occupation_wing_map)) return false;
/* 1318 */       if (this.effectwingoccid != _o_.effectwingoccid) return false;
/* 1319 */       if (!this.occ2lastplanoccid.equals(_o_.occ2lastplanoccid)) return false;
/* 1320 */       if (!this.newoccplans.equals(_o_.newoccplans)) return false;
/* 1321 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1327 */       int _h_ = 0;
/* 1328 */       _h_ += this.wings.hashCode();
/* 1329 */       _h_ += this.curplan;
/* 1330 */       _h_ += this.transfer_occupation_wing_map.hashCode();
/* 1331 */       _h_ += this.effectwingoccid;
/* 1332 */       _h_ += this.occ2lastplanoccid.hashCode();
/* 1333 */       _h_ += this.newoccplans.hashCode();
/* 1334 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1340 */       StringBuilder _sb_ = new StringBuilder();
/* 1341 */       _sb_.append("(");
/* 1342 */       _sb_.append(this.wings);
/* 1343 */       _sb_.append(",");
/* 1344 */       _sb_.append(this.curplan);
/* 1345 */       _sb_.append(",");
/* 1346 */       _sb_.append(this.transfer_occupation_wing_map);
/* 1347 */       _sb_.append(",");
/* 1348 */       _sb_.append(this.effectwingoccid);
/* 1349 */       _sb_.append(",");
/* 1350 */       _sb_.append(this.occ2lastplanoccid);
/* 1351 */       _sb_.append(",");
/* 1352 */       _sb_.append(this.newoccplans);
/* 1353 */       _sb_.append(")");
/* 1354 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AllWingPlans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */